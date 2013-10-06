songPlaying = 0

$( function() {
	var maxHeight = 500;

	$(".comment").each(function() {
        $(this).bind("input", function() {
            $(this).data("changed", true);
            $(this).addClass("selected");
        });

        $(this).bind("propertychange", function() {
            $(this).data("changed", true);
            $(this).addClass("selected");
        });


		$(this).blur(function() {
            if($(this).data("changed")) {
                var song = $(this).attr('id').substr(7);
                var raati = getQueryParam('id');
                var comment = $("#comment"+song).val();
                var score = $("#song"+song).val();
                var parms = {song: song, raati: raati, comment: comment, vote:score}
                savevote(parms);
            }
		});

		/*
		var fit = function() {
			fitToContent($(this), maxHeight);
		}

		$(this).attr('relative_error', 0)
		$(this).keyup(fit);
		fitToContent($(this), maxHeight);
		 */
	});

	$(".voteselect").each(function() {
		$(this).change(function() {
			var song = $(this).attr('id').substr(4);
			var vote = $(this).val();
			var raati = getQueryParam('id');
			var comment = $("#comment"+song).val();
			var parms = {song: song, vote: vote, raati:raati, comment: comment};
			savevote(parms);
		});
	});
});      

function playSong(song, url) {
	$("#player").css("visibility", "visible");
	if(song != songPlaying) {
		$("#play"+songPlaying).attr('src', 'images/play.png');
		niftyplayer('niftyPlayer1').loadAndPlay(url);
		songPlaying = song
		$("#play"+song).attr('src', 'images/pause.png');
	} else {
		niftyplayer('niftyPlayer1').pause(url);
		$("#play"+song).attr('src', 'images/play.png');
		songPlaying = 0
	}
}

function fitToContent(text, maxHeight) {
	// console.debug("fit");
	var adjustedHeight = text.height();
	var relative_error = parseInt(text.attr('relative_error'));
	if (!maxHeight || maxHeight > adjustedHeight) {
		adjustedHeight = Math.max(text[0].scrollHeight, adjustedHeight);
		if (maxHeight)
			adjustedHeight = Math.min(maxHeight, adjustedHeight);
		if ((adjustedHeight - relative_error) > text.height()) {
			text.css('height', (adjustedHeight - relative_error) + "px");
			// chrome fix
			if (text[0].scrollHeight != adjustedHeight) {
				var relative = text[0].scrollHeight - adjustedHeight;
				if (relative_error != relative) {
					text.attr('relative_error', relative + relative_error);
				}
			}
		}
	}
}


function savevote(parms) {
	// using getJSON broke special characters
	$.ajax({
		type: "POST",
		url: "json/savevote",
		data: parms,
		success: function(data) {
			if(!data || data.result != "ok") {
				return;
			}
			if(data.normalized) {
				updateNormalized(data.normalized)
			}
			$("#comment"+parms.song).removeClass("selected");
            $("#comment"+parms.song).data("changed", false);
		},
		error: function (XMLHttpRequest, textStatus, errorThrown) {
			alert("Error saving vote!")
		}
	});
}

function updateNormalized(scores) {
	// console.debug("updating normalized scores")
	$(".normScore").each(function() {
		// debugger;
		var id = $(this).attr('id').substr(9);
		var normscore = scores[id];
		var text = normscore ? normscore.toFixed(1) : "0.0";
		$("#normScore"+id).text(text);
		var color = scoreToColor(text);
		// console.debug(color);
		$("#normScore"+id).css("background-color", color);
	});
}

function scoreToColor(score) {
	/*
    k_r = -22.1
    c_r = 255

    k_g = 22.1
    c_g = 34

    a = -4.9
    b = 49
    c = 22

    red = (k_r * score) + c_r
    grn = (k_g * score) + c_g
    blu = a*score*score + b*score + c
	 */


	if(!score || parseFloat(score)==0) {
		return "#ffffff"
	}

	var k_r = -22.1
	var c_r = 255
	var k_g = 22.1
	var c_g = 34
	var a = -4.9
	var b = 49
	var c = 22

	var red = parseInt((k_r * score) + c_r)
	var grn = parseInt((k_g * score) + c_g)
	var blu = parseInt(a*score*score + b*score + c)

	return "#"+red.toString(16)+grn.toString(16)+blu.toString(16)
}

function getQueryParam(name) {
	name = name.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
	var regex = new RegExp("[\\?&]"+name+"=([^&#]*)");
	var results = regex.exec( window.location.href );
	if( results == null ) {
		return "";
	} else {
		return results[1];
	}
}