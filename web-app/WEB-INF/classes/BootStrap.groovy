import org.codehaus.groovy.grails.commons.DomainClassArtefactHandler;

import graati.*
import grails.util.GrailsUtil

class BootStrap {
	
	def springSecurityService
	private static final ms = 1000 * 60 * 15
	
	def init = { servletContext ->
		
		switch (GrailsUtil.environment) {
			case 'production':
			//createUBRaati()
			break;
			
			case 'development':
			createUBRaati()
			createUserData()
			createTestData()
			createUBRaatiTestVotes()
			break;
			
			case 'test':
			//createUBRaati()
			break;
		}
	}
	
	def createUBRaati() {
		println "Creating UbRaati"
		
		Artist ub = new Artist(name: 'Ultra Bra').save()
		Album a1 = new Album(
				name: 'Vapaaherran elämää', 
				releaseYear: 1996, 
				artist: ub).save()
		Album a2 = new Album(
				name: 'Kroketti',
				releaseYear: 1997,
				artist: ub).save()
		Album a3 = new Album(
				name: 'Kalifornia',
				releaseYear: 1999,
				artist: ub).save()
		Album a4 = new Album(
				name: 'Vesireittejä',
				releaseYear: 2000,
				artist: ub).save()
		Album a5 = new Album(
				name: 'Sinä päivänä kun synnyin (CD2)',
				releaseYear: 2001,
				artist: ub).save()
		
		
		Song a1s1 = new Song(
				name: 'Nainen, joka elää vapaaherran elämää', 
				indexNumber: 1, 
				album: a1,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vapaaherran_el%c3%a4m%c3%a4%c3%a4_-_01_-_Nainen,_joka_el%c3%a4%c3%a4_vapaaherran_el%c3%a4m%c3%a4%c3%a4.mp3").save()
		Song a1s2 = new Song(
				name: 'Naispaholainen',
				indexNumber: 2,
				album: a1,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vapaaherran_el%c3%a4m%c3%a4%c3%a4_-_02_-_Naispaholainen.mp3").save()
		Song a1s3 = new Song(
				name: 'Säkeitä Erwin Rommelille',
				indexNumber: 3,
				album: a1,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vapaaherran_el%c3%a4m%c3%a4%c3%a4_-_03_-_S%c3%a4keit%c3%a4_Erwin_Rommelille.mp3").save()
		Song a1s4 = new Song(
				name: 'Ken Saro-Wiva on kuollut',
				indexNumber: 4,
				album: a1,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vapaaherran_el%c3%a4m%c3%a4%c3%a4_-_04_-_Ken_Saro-Wiwa_on_kuollut.mp3").save()
		Song a1s5 = new Song(
				name: 'Pikku kissa',
				indexNumber: 5,
				album: a1,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vapaaherran_el%c3%a4m%c3%a4%c3%a4_-_05_-_Pikku_kissa.mp3").save()
		Song a1s6 = new Song(
				name: 'Kahdeksanvuotiaana',
				indexNumber: 6,
				album: a1,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vapaaherran_el%c3%a4m%c3%a4%c3%a4_-_06_-_Kahdeksanvuotiaana.mp3").save()
		Song a1s7 = new Song(
				name: 'Moskova',
				indexNumber: 7,
				album: a1,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vapaaherran_el%c3%a4m%c3%a4%c3%a4_-_07_-_Moskova.mp3").save()
		Song a1s8 = new Song(
				name: 'Helsinki',
				indexNumber: 8,
				album: a1,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vapaaherran_el%c3%a4m%c3%a4%c3%a4_-_08_-_Helsinki.mp3").save()
		Song a1s9 = new Song(
				name: 'Entäs nyt?',
				indexNumber: 9,
				album: a1,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vapaaherran_el%c3%a4m%c3%a4%c3%a4_-_09_-_Ent%c3%a4s_nyt-.mp3").save()
		Song a1s10 = new Song(
				name: 'Sankaritar',
				indexNumber: 10,
				album: a1,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vapaaherran_el%c3%a4m%c3%a4%c3%a4_-_10_-_Sankaritar.mp3").save()
		Song a1s11 = new Song(
				name: 'Tel Aviv, Tel Aviv',
				indexNumber: 11,
				album: a1,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vapaaherran_el%c3%a4m%c3%a4%c3%a4_-_11_-_Tel_Aviv,_Tel_Aviv.mp3").save()
		Song a1s12 = new Song(
				name: 'Kuka haluaa?',
				indexNumber: 12,
				album: a1,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vapaaherran_el%c3%a4m%c3%a4%c3%a4_-_12_-_Kuka_haluaa-.mp3").save()
		Song a1s13 = new Song(
				name: 'Veturi, taksi, valtamerilaiva',
				indexNumber: 13,
				album: a1,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vapaaherran_el%c3%a4m%c3%a4%c3%a4_-_13_-_Veturi,_taksi,_valtamerilaiva.mp3").save()
		Song a1s14 = new Song(
				name: 'Laulu asioista',
				indexNumber: 14,
				album: a1,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vapaaherran_el%c3%a4m%c3%a4%c3%a4_-_14_-_Laulu_asioista.mp3").save()
		[a1s1,a1s2,a1s3,a1s4,a1s5,a1s6,a1s7,a1s8,a1s9,a1s10,a1s11,a1s12,a1s13,a1s14].each { 
			a1.addToSongs(it)
		}
		a1.save(flush:true)
		
		Song a2s1 = new Song(
				name: 'Savanni nukahtaa',
				indexNumber: 1,
				album: a2,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kroketti_-_01_-_Savanni_nukahtaa.mp3").save()
		
		Song a2s2 = new Song(
				name: 'Hauki',
				indexNumber: 2,
				album: a2,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kroketti_-_02_-_Hauki.mp3").save()
		
		Song a2s3 = new Song(
				name: 'Sinä lähdit pois',
				indexNumber: 3,
				album: a2,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kroketti_-_03_-_Sin%c3%a4_l%c3%a4hdit_pois.mp3").save()
		
		Song a2s4 = new Song(
				name: 'Pärnu',
				indexNumber: 4,
				album: a2,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kroketti_-_04_-_P%c3%a4rnu.mp3").save()
		
		Song a2s5 = new Song(
				name: 'Minä suojelen sinua kaikelta',
				indexNumber: 5,
				album: a2,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kroketti_-_05_-_Min%c3%a4_suojelen_sinua_kaikelta.mp3").save()
		
		Song a2s6 = new Song(
				name: 'Lähetystyö',
				indexNumber: 6,
				album: a2,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kroketti_-_06_-_L%c3%a4hetysty%c3%b6.mp3").save()
		
		Song a2s7 = new Song(
				name: 'Tule pelaamaan meidän kanssa krokettia',
				indexNumber: 7,
				album: a2,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kroketti_-_07_-_Tule_pelaamaan_meid%c3%a4n_kanssa_krokettia.mp3").save()
		
		Song a2s8 = new Song(
				name: 'Älä soita tänne enää koskaan',
				indexNumber: 8,
				album: a2,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kroketti_-_08_-_%c3%84l%c3%a4_soita_t%c3%a4nne_en%c3%a4%c3%a4_koskaan.mp3").save()
		
		Song a2s9 = new Song(
				name: 'Heppa',
				indexNumber: 9,
				album: a2,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kroketti_-_09_-_Heppa.mp3").save()
		
		Song a2s10 = new Song(
				name: 'Haikara',
				indexNumber: 10,
				album: a2,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kroketti_-_10_-_Haikara.mp3").save()
		
		Song a2s11 = new Song(
				name: 'Ero',
				indexNumber: 11,
				album: a2,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kroketti_-_11_-_Ero.mp3").save()
		
		Song a2s12 = new Song(
				name: 'Suosi ulkomaista',
				indexNumber: 12,
				album: a2,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kroketti_-_12_-_Suosi_ulkomaista.mp3").save()
		
		Song a2s13 = new Song(
				name: 'Yöllä',
				indexNumber: 13,
				album: a2,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kroketti_-_13_-_Y%c3%b6ll%c3%a4.mp3").save()
		
		[ a2s1, a2s2, a2s3, a2s4, a2s5, a2s6, a2s7, a2s8, a2s9, a2s10, a2s11, a2s12, a2s13 ]. each {
			a2.addToSongs(it)
		}
		a2.save(flush:true)
		
		Song a3s1 = new Song(
				name: 'Kalifornian ruosteiset kukkulat',
				indexNumber: 1,
				album: a3,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kalifornia_-_01_-_Kalifornian_ruosteiset_kukkulat.mp3").save()
		
		Song a3s2 = new Song(
				name: 'Jäätelöauto',
				indexNumber: 2,
				album: a3,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kalifornia_-_02_-_J%c3%a4%c3%a4tel%c3%b6auto.mp3").save()
		
		Song a3s3 = new Song(
				name: 'Hei kuule Suomi',
				indexNumber: 3,
				album: a3,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kalifornia_-_03_-_Hei_kuule_Suomi.mp3").save()
		
		Song a3s4 = new Song(
				name: 'Sokeana hetkenä',
				indexNumber: 4,
				album: a3,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kalifornia_-_04_-_Sokeana_hetken%c3%a4.mp3").save()
		
		Song a3s5 = new Song(
				name: 'Ilmiöitä',
				indexNumber: 5,
				album: a3,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kalifornia_-_05_-_Ilmi%c3%b6it%c3%a4.mp3").save()
		
		Song a3s6 = new Song(
				name: 'He kääntävät tyynynsä',
				indexNumber: 6,
				album: a3,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kalifornia_-_06_-_He_k%c3%a4%c3%a4nt%c3%a4v%c3%a4t_tyynyns%c3%a4.mp3").save()
		
		Song a3s7 = new Song(
				name: 'Jos haluatte',
				indexNumber: 7,
				album: a3,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kalifornia_-_07_-_Jos_haluatte.mp3").save()
		
		Song a3s8 = new Song(
				name: 'Kirjoituksia',
				indexNumber: 8,
				album: a3,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kalifornia_-_08_-_Kirjoituksia.mp3").save()
		
		Song a3s9 = new Song(
				name: 'Tylsää, tylsää',
				indexNumber: 9,
				album: a3,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kalifornia_-_09_-_Tyls%c3%a4%c3%a4,_tyls%c3%a4%c3%a4.mp3").save()
		
		Song a3s10 = new Song(
				name: 'Kun vaihtuu vuosituhat',
				indexNumber: 10,
				album: a3,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kalifornia_-_10_-_Kun_vaihtuu_vuosituhat.mp3").save()
		
		Song a3s11 = new Song(
				name: 'Tyttöjen välisestä ystävyydestä',
				indexNumber: 11,
				album: a3,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kalifornia_-_11_-_Tytt%c3%b6jen_v%c3%a4lisest%c3%a4_yst%c3%a4vyydest%c3%a4.mp3").save()
		
		Song a3s12 = new Song(
				name: 'Helsinki-Vantaa',
				indexNumber: 12,
				album: a3,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kalifornia_-_12_-_Helsinki-Vantaa.mp3").save()
		
		Song a3s13 = new Song(
				name: 'Musta, niljaisten lehtien kaupunki',
				indexNumber: 13,
				album: a3,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Kalifornia_-_13_-_Musta,_niljaisten_lehtien_kaupunki.mp3").save()
		
		[a3s1, a3s2, a3s3, a3s4, a3s5, a3s6, a3s7, a3s8, a3s9, a3s10, a3s11, a3s12, a3s13 ].each { 
			a3.addToSongs(it)
		}
		a3.save(flush:true)
		
		Song a4s1 = new Song(
				name: 'Kaunis ja ylpee',
				indexNumber: 1,
				album: a4,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vesireittej%c3%a4_-_01_-_Kaunis_Ja_Ylpee.mp3").save()
		
		Song a4s2 = new Song(
				name: 'Rubikin kuutio',
				indexNumber: 2,
				album: a4,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vesireittej%c3%a4_-_02_-_Rubikin_Kuutio.mp3").save()
		
		Song a4s3 = new Song(
				name: 'Vesireittejä',
				indexNumber: 3,
				album: a4,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vesireittej%c3%a4_-_03_-_Vesireittej%c3%a4.mp3").save()
		
		Song a4s4 = new Song(
				name: 'Heikko valo',
				indexNumber: 4,
				album: a4,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vesireittej%c3%a4_-_04_-_Heikko_Valo.mp3").save()
		
		Song a4s5 = new Song(
				name: 'Kuiskaus',
				indexNumber: 5,
				album: a4,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vesireittej%c3%a4_-_05_-_Kuiskaus.mp3").save()
		
		Song a4s6 = new Song(
				name: 'Pinnan alla',
				indexNumber: 6,
				album: a4,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vesireittej%c3%a4_-_06_-_Pinnan_Alla.mp3").save()
		
		Song a4s7 = new Song(
				name: 'Tänään',
				indexNumber: 7,
				album: a4,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vesireittej%c3%a4_-_07_-_T%c3%a4n%c3%a4%c3%a4n.mp3").save()
		
		Song a4s8 = new Song(
				name: 'Kun näen sinut kaukaa',
				indexNumber: 8,
				album: a4,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vesireittej%c3%a4_-_08_-_Kun_N%c3%a4en_Sinut_Kaukaa.mp3").save()
		
		Song a4s9 = new Song(
				name: 'Poika vuoden takaa',
				indexNumber: 9,
				album: a4,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vesireittej%c3%a4_-_09_-_Poika_Vuoden_Takaa.mp3").save()
		
		Song a4s10 = new Song(
				name: 'Mitä on taivas?',
				indexNumber: 10,
				album: a4,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vesireittej%c3%a4_-_10_-_Mit%c3%a4_On_Taivas-.mp3").save()
		
		Song a4s11 = new Song(
				name: 'Siili',
				indexNumber: 11,
				album: a4,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vesireittej%c3%a4_-_11_-_Siili.mp3").save()
		
		Song a4s12 = new Song(
				name: 'Kohtaaminen',
				indexNumber: 12,
				album: a4,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vesireittej%c3%a4_-_12_-_Kohtaaminen.mp3").save()
		
		Song a4s13 = new Song(
				name: 'Itket ja kuuntelet',
				indexNumber: 13,
				album: a4,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Vesireittej%c3%a4_-_13_-_Itket_Ja_Kuuntelet.mp3").save()
		
		[a4s1, a4s2, a4s3, a4s4, a4s5, a4s6, a4s7, a4s8, a4s9, a4s10, a4s11, a4s12, a4s13].each { 
			a4.addToSongs(it)
		}
		a4.save(flush:true)
		
		Song a5s1 = new Song(
				name: 'Kalpeat kasvot',
				indexNumber: 1,
				album: a5,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Sin%c3%a4_p%c3%a4iv%c3%a4n%c3%a4_kun_synnyin_(cd_2)_-_01_-_Kalpeat_kasvot.mp3").save()
		
		Song a5s2 = new Song(
				name: 'Villiviini',
				indexNumber: 2,
				album: a5,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Sin%c3%a4_p%c3%a4iv%c3%a4n%c3%a4_kun_synnyin_(cd_2)_-_02_-_Villiviini.mp3").save()
		
		Song a5s3 = new Song(
				name: 'Laulu marsalkka Mannerheimista',
				indexNumber: 3,
				album: a5,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Sin%c3%a4_p%c3%a4iv%c3%a4n%c3%a4_kun_synnyin_(cd_2)_-_03_-_Laulu_marsalkka_Mannerheimista.mp3").save()
		
		Song a5s4 = new Song(
				name: 'Lähettäkää minulle kirjoja',
				indexNumber: 4,
				album: a5,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Sin%c3%a4_p%c3%a4iv%c3%a4n%c3%a4_kun_synnyin_(cd_2)_-_04_-_L%c3%a4hett%c3%a4k%c3%a4%c3%a4_minulle_kirjoja.mp3").save()
		
		Song a5s5 = new Song(
				name: 'Siirrän sokeriastiaa',
				indexNumber: 5,
				album: a5,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Sin%c3%a4_p%c3%a4iv%c3%a4n%c3%a4_kun_synnyin_(cd_2)_-_05_-_Siirr%c3%a4n_sokeriastiaa.mp3").save()
		
		Song a5s6 = new Song(
				name: 'Lapsuus loppui',
				indexNumber: 6,
				album: a5,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Sin%c3%a4_p%c3%a4iv%c3%a4n%c3%a4_kun_synnyin_(cd_2)_-_06_-_Lapsuus_loppui.mp3").save()
		
		Song a5s7 = new Song(
				name: 'Kaikki on hetken tässä',
				indexNumber: 7,
				album: a5,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Sin%c3%a4_p%c3%a4iv%c3%a4n%c3%a4_kun_synnyin_(cd_2)_-_07_-_Kaikki_on_hetken_t%c3%a4ss%c3%a4.mp3").save()
		
		Song a5s8 = new Song(
				name: 'Hyppään',
				indexNumber: 8,
				album: a5,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Sin%c3%a4_p%c3%a4iv%c3%a4n%c3%a4_kun_synnyin_(cd_2)_-_08_-_Hypp%c3%a4%c3%a4n.mp3").save()
		
		Song a5s9 = new Song(
				name: 'Me yhtenäistämme',
				indexNumber: 9,
				album: a5,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Sin%c3%a4_p%c3%a4iv%c3%a4n%c3%a4_kun_synnyin_(cd_2)_-_09_-_Me_yhten%c3%a4ist%c3%a4mme.mp3").save()
		
		Song a5s10 = new Song(
				name: 'Sinä päivänä kun synnyin',
				indexNumber: 10,
				album: a5,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Sin%c3%a4_p%c3%a4iv%c3%a4n%c3%a4_kun_synnyin_(cd_2)_-_10_-_Sin%c3%a4_p%c3%a4iv%c3%a4n%c3%a4_kun_synnyin.mp3").save()
		
		Song a5s11 = new Song(
				name: 'Eniten',
				indexNumber: 11,
				album: a5,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Sin%c3%a4_p%c3%a4iv%c3%a4n%c3%a4_kun_synnyin_(cd_2)_-_11_-_Eniten.mp3").save()
		
		Song a5s12 = new Song(
				name: 'Avaruuden lapsia',
				indexNumber: 12,
				album: a5,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Sin%c3%a4_p%c3%a4iv%c3%a4n%c3%a4_kun_synnyin_(cd_2)_-_15_-_Avaruuden_lapsia.mp3").save()
		
		Song a5s13 = new Song(
				name: 'Houkutusten kiihottava maku',
				indexNumber: 13,
				album: a5,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Sin%c3%a4_p%c3%a4iv%c3%a4n%c3%a4_kun_synnyin_(cd_2)_-_16_-_Houkutusten_kiihottava_maku.mp3").save()
		
		Song a5s14 = new Song(
				name: 'Ampukaa komissaarit, nuo hullut koirat!',
				indexNumber: 14,
				album: a5,
				audioUrl: "http://koti.welho.com/senhirsj/UB/Ultra_Bra_-_Sin%c3%a4_p%c3%a4iv%c3%a4n%c3%a4_kun_synnyin_(cd_2)_-_18_-_Ampukaa_komissaarit,_nuo_hullut_koirat!.mp3").save()
		
		
		[a5s1, a5s2, a5s3, a5s4, a5s5, a5s6, a5s7, a5s8, a5s9, a5s10, a5s11, a5s12, a5s13, a5s14].each {
			a5.addToSongs(it)
		}
		a5.save(flush:true)
		
		def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
		def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
		
		String password = springSecurityService.encodePassword('bra4ti')
		User esa = new User(username: 'esa', enabled: true, password: password, email:"esa@everholt.org").save(flush:true)
		
		println "user: $esa admin: $adminRole: user: $userRole"
		UserRole.create(esa, adminRole, true)
		UserRole.create(esa, userRole, true)
		
		Raati raati = new Raati(
				name: 'Ultra Braati', 
				owner: esa,
				ends: new Date()-1,
				privacy: RaatiPrivacy.PARTICIPANT_VOTING,
				resultsReleased: true)
		
		[a1, a2, a3, a4, a5].each {
			raati.addToAlbums(it)
		}
		raati.save(flush:true)
	}
	
	def createTestData() {
		User user = User.findByUsername('test')
		User user2 = User.findByUsername('test1')
		User user3 = User.findByUsername('test2')
		User user4 = User.findByUsername('test3')
		Artist q = new Artist(name: 'Queen').save()
		Album a1 = new Album(name: 'A Kind Of Magic', releaseYear: 1986, artist: q).save()
		Song s1 = new Song(name: 'One Vision', indexNumber: 1, album: a1, audioUrl: "http://esmo.kapsi.fi/mp3/esa1.mp3").save()
		Song s2 = new Song(name: 'A Kind of Magic', indexNumber: 2, album: a1, audioUrl: "http://esmo.kapsi.fi/mp3/esa2.mp3").save()
		Song s3 = new Song(name: 'One Year Of Love', indexNumber: 3, album: a1, audioUrl: "http://esmo.kapsi.fi/mp3/esa3.mp3").save()
		a1.addToSongs(s1).addToSongs(s2).addToSongs(s3).save()
		Artist c = new Artist(name: 'Carcass').save()
		Album a2 = new Album(name: 'Heartwork', releaseYear: 1993, artist: c).save()
		Song s4 = new Song(name: 'Carnal Forge', indexNumber: 2, album: a2, audioUrl: "http://esmo.kapsi.fi/mp3/esa4.mp3").save()
		Song s5 = new Song(name: 'Arbeit Macht Flesch', indexNumber: 7, album: a2, audioUrl: "http://esmo.kapsi.fi/mp3/esa1.mp3").save()
		
		Date now = new Date()
		Raati testiRaati = new Raati(name: 'TestiRaati', owner: user, ends: now+5).addToAlbums(a1).addToAlbums(a2).save()
		Raati salaRaati = new Raati(name: 'SalaRaati', owner: user, privacy: RaatiPrivacy.PARTICIPANT_VOTING, ends: now+2).addToAlbums(a2).addToParticipants(user2).save()
		Raati memberRaati = new Raati(name: 'ParticipantVoteRaati', privacy: RaatiPrivacy.PARTICIPANT_VIEWING, owner: user2, ends: now+2).addToAlbums(a1).addToParticipants(user3).save()
		Raati expiredRaati = new Raati(name: 'ExpiredRaati', privacy: RaatiPrivacy.PUBLIC, owner: user, ends: now-22, resultsReleased: true).addToAlbums(a1).save()
		
		Vote v1 = new Vote(user: user, raati: expiredRaati, song: s1, score: 4.5).save()
		Vote v2 = new Vote(user: user, raati: expiredRaati, song: s2, score: 3.5).save()
		Vote v3 = new Vote(user: user, raati: expiredRaati, song: s3, score: 9.5).save()
		
		Vote v4 = new Vote(user: user2, raati: expiredRaati, song: s1, score: 1.5).save()
		Vote v5 = new Vote(user: user2, raati: expiredRaati, song: s2, score: 5.5).save()
		Vote v6 = new Vote(user: user2, raati: expiredRaati, song: s3, score: 6.5).save()
		
		Vote v7 = new Vote(user: user3, raati: expiredRaati, song: s1, score: 0.5).save()
		Vote v8 = new Vote(user: user3, raati: expiredRaati, song: s2, score: 8.5).save()
		Vote v9 = new Vote(user: user3, raati: expiredRaati, song: s3, score: 7.5).save()
	}
	
	def createUserData() {
		
		def adminRole = Role.findByAuthority('ROLE_ADMIN');
		def userRole = Role.findByAuthority('ROLE_USER');
		
		String password = springSecurityService.encodePassword('password')
		def testUser = new User(username: 'test', enabled: true, password: password, email:"foo1@bar.com")
		testUser.save(flush: true)
		def testUser2 = new User(username: 'test1', enabled: true, password: password, email:"foo2@bar.com").save()
		def testUser3 = new User(username: 'test2', enabled: true, password: password, email:"foo3@bar.com").save()
		def testUser4 = new User(username: 'test3', enabled: true, password: password, email:"foo4@bar.com").save()
		
		UserRole.create(testUser, adminRole, true)
		UserRole.create(testUser, userRole, true)
	}

	def createUBRaatiTestVotes() {
		println "creating ubraati test votes..."
		String password = springSecurityService.encodePassword('password')
		def numUsers = 8
		def users = []
		def userRole = Role.findByAuthority('ROLE_USER');
		(1 .. numUsers).each {
			def user = new User(username: "ubvoter${it}", enabled: true, password: password, email:"foo${it}@bar.com").save(flush:true)
			UserRole.create(user, userRole, true)
			users.add(user)
		}
		Random random = new Random()
		def raati = Raati.findByName("Ultra Braati")
		raati.albums.each { album ->
			album.songs.each { song ->
				users.each { user -> 
					def score = (random.nextInt(19 as int)+1)/2
					def comment = "foobar foo bar. "*random.nextInt(30)
					//println score
					Vote vote = new Vote(user: user, raati: raati, song: song, score: score, comment:comment).save()
				}
			}	
		}
		println "done!"
	}

	def destroy = {
	}
}
