package com.mehdigm.cimastream4.utils

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fleeksoft.ksoup.Ksoup
import com.mehdigm.cimastream4.AudioFile
import com.mehdigm.cimastream4.IDownloadableMinimum
import com.mehdigm.cimastream4.Prerelease
import com.mehdigm.cimastream4.SubtitleFile
import com.mehdigm.cimastream4.USER_AGENT
import com.mehdigm.cimastream4.app
import com.mehdigm.cimastream4.extractors.Acefile
import com.mehdigm.cimastream4.extractors.Ahvsh
import com.mehdigm.cimastream4.extractors.Aico
import com.mehdigm.cimastream4.extractors.Antarcticadocs
import com.mehdigm.cimastream4.extractors.Asnwish
import com.mehdigm.cimastream4.extractors.Auvexiug
import com.mehdigm.cimastream4.extractors.Awish
import com.mehdigm.cimastream4.extractors.BgwpCC
import com.mehdigm.cimastream4.extractors.BigwarpArt
import com.mehdigm.cimastream4.extractors.BigwarpIO
import com.mehdigm.cimastream4.extractors.Blogger
import com.mehdigm.cimastream4.extractors.ByseSX
import com.mehdigm.cimastream4.extractors.Bysezejataos
import com.mehdigm.cimastream4.extractors.ByseBuho
import com.mehdigm.cimastream4.extractors.ByseVepoin
import com.mehdigm.cimastream4.extractors.ByseQekaho
import com.mehdigm.cimastream4.extractors.Cavanhabg
import com.mehdigm.cimastream4.extractors.Cda
import com.mehdigm.cimastream4.extractors.Cdnplayer
import com.mehdigm.cimastream4.extractors.CdnwishCom
import com.mehdigm.cimastream4.extractors.CloudMailRu
import com.mehdigm.cimastream4.extractors.ContentX
import com.mehdigm.cimastream4.extractors.CsstOnline
import com.mehdigm.cimastream4.extractors.D0000d
import com.mehdigm.cimastream4.extractors.D000dCom
import com.mehdigm.cimastream4.extractors.DBfilm
import com.mehdigm.cimastream4.extractors.Dailymotion
import com.mehdigm.cimastream4.extractors.DatabaseGdrive
import com.mehdigm.cimastream4.extractors.DatabaseGdrive2
import com.mehdigm.cimastream4.extractors.DesuArcg
import com.mehdigm.cimastream4.extractors.DesuDrive
import com.mehdigm.cimastream4.extractors.DesuOdchan
import com.mehdigm.cimastream4.extractors.DesuOdvip
import com.mehdigm.cimastream4.extractors.Dhcplay
import com.mehdigm.cimastream4.extractors.Dhtpre
import com.mehdigm.cimastream4.extractors.Dokicloud
import com.mehdigm.cimastream4.extractors.DoodCxExtractor
import com.mehdigm.cimastream4.extractors.DoodLaExtractor
import com.mehdigm.cimastream4.extractors.DoodPmExtractor
import com.mehdigm.cimastream4.extractors.DoodShExtractor
import com.mehdigm.cimastream4.extractors.DoodSoExtractor
import com.mehdigm.cimastream4.extractors.DoodToExtractor
import com.mehdigm.cimastream4.extractors.DoodWatchExtractor
import com.mehdigm.cimastream4.extractors.DoodWfExtractor
import com.mehdigm.cimastream4.extractors.DoodWsExtractor
import com.mehdigm.cimastream4.extractors.DoodYtExtractor
import com.mehdigm.cimastream4.extractors.Doodspro
import com.mehdigm.cimastream4.extractors.Dsvplay
import com.mehdigm.cimastream4.extractors.Doodporn
import com.mehdigm.cimastream4.extractors.DoodstreamCom
import com.mehdigm.cimastream4.extractors.Dooood
import com.mehdigm.cimastream4.extractors.Ds2play
import com.mehdigm.cimastream4.extractors.Ds2video
import com.mehdigm.cimastream4.extractors.DsstOnline
import com.mehdigm.cimastream4.extractors.Dumbalag
import com.mehdigm.cimastream4.extractors.Dwish
import com.mehdigm.cimastream4.extractors.Embedgram
import com.mehdigm.cimastream4.extractors.EmturbovidExtractor
import com.mehdigm.cimastream4.extractors.Evoload
import com.mehdigm.cimastream4.extractors.Evoload1
import com.mehdigm.cimastream4.extractors.Ewish
import com.mehdigm.cimastream4.extractors.FEmbed
import com.mehdigm.cimastream4.extractors.FEnet
import com.mehdigm.cimastream4.extractors.Fastream
import com.mehdigm.cimastream4.extractors.FeHD
import com.mehdigm.cimastream4.extractors.Fembed9hd
import com.mehdigm.cimastream4.extractors.FileMoon
import com.mehdigm.cimastream4.extractors.FileMoonIn
import com.mehdigm.cimastream4.extractors.FileMoonSx
import com.mehdigm.cimastream4.extractors.FilemoonV2
import com.mehdigm.cimastream4.extractors.Filesim
import com.mehdigm.cimastream4.extractors.Firestream
import com.mehdigm.cimastream4.extractors.FirestreamSite
import com.mehdigm.cimastream4.extractors.Multimoviesshg
import com.mehdigm.cimastream4.extractors.FlaswishCom
import com.mehdigm.cimastream4.extractors.Flyfile
import com.mehdigm.cimastream4.extractors.FourCX
import com.mehdigm.cimastream4.extractors.FourPichive
import com.mehdigm.cimastream4.extractors.FourPlayRu
import com.mehdigm.cimastream4.extractors.Fplayer
import com.mehdigm.cimastream4.extractors.FsstOnline
import com.mehdigm.cimastream4.extractors.GDMirrorbot
import com.mehdigm.cimastream4.extractors.GUpload
import com.mehdigm.cimastream4.extractors.GamoVideo
import com.mehdigm.cimastream4.extractors.Gdriveplayer
import com.mehdigm.cimastream4.extractors.Gdriveplayerapi
import com.mehdigm.cimastream4.extractors.Gdriveplayerapp
import com.mehdigm.cimastream4.extractors.Gdriveplayerbiz
import com.mehdigm.cimastream4.extractors.Gdriveplayerco
import com.mehdigm.cimastream4.extractors.Gdriveplayerfun
import com.mehdigm.cimastream4.extractors.Gdriveplayerio
import com.mehdigm.cimastream4.extractors.Gdriveplayerme
import com.mehdigm.cimastream4.extractors.Gdriveplayerorg
import com.mehdigm.cimastream4.extractors.Gdriveplayerus
import com.mehdigm.cimastream4.extractors.Geodailymotion
import com.mehdigm.cimastream4.extractors.Gofile
import com.mehdigm.cimastream4.extractors.GoodstreamExtractor
import com.mehdigm.cimastream4.extractors.Guccihide
import com.mehdigm.cimastream4.extractors.Guxhag
import com.mehdigm.cimastream4.extractors.HDMomPlayer
import com.mehdigm.cimastream4.extractors.HDPlayerSystem
import com.mehdigm.cimastream4.extractors.HDStreamAble
import com.mehdigm.cimastream4.extractors.Habetar
import com.mehdigm.cimastream4.extractors.Handfacesnap
import com.mehdigm.cimastream4.extractors.Haxloppd
import com.mehdigm.cimastream4.extractors.Hexload
import com.mehdigm.cimastream4.extractors.Hgcloudto
import com.mehdigm.cimastream4.extractors.HglinkTo
import com.mehdigm.cimastream4.extractors.HgplayCDN
import com.mehdigm.cimastream4.extractors.Hotlinger
import com.mehdigm.cimastream4.extractors.HubCloud
import com.mehdigm.cimastream4.extractors.Hxfile
import com.mehdigm.cimastream4.extractors.HlsWish
import com.mehdigm.cimastream4.extractors.HubuCloud
import com.mehdigm.cimastream4.extractors.InternetArchive
import com.mehdigm.cimastream4.extractors.JWPlayer
import com.mehdigm.cimastream4.extractors.Jeniusplay
import com.mehdigm.cimastream4.extractors.Jodwish
import com.mehdigm.cimastream4.extractors.Keephealth
import com.mehdigm.cimastream4.extractors.KotakAnimeid
import com.mehdigm.cimastream4.extractors.Kotakajair
import com.mehdigm.cimastream4.extractors.Krakenfiles
import com.mehdigm.cimastream4.extractors.Kswplayer
import com.mehdigm.cimastream4.extractors.LayarKaca
import com.mehdigm.cimastream4.extractors.Linkbox
import com.mehdigm.cimastream4.extractors.LuluStream
import com.mehdigm.cimastream4.extractors.Lulustream1
import com.mehdigm.cimastream4.extractors.Lulustream2
import com.mehdigm.cimastream4.extractors.Luluvdoo
import com.mehdigm.cimastream4.extractors.Luxubu
import com.mehdigm.cimastream4.extractors.Lvturbo
import com.mehdigm.cimastream4.extractors.MailRu
import com.mehdigm.cimastream4.extractors.Maxstream
import com.mehdigm.cimastream4.extractors.Mediafire
import com.mehdigm.cimastream4.extractors.Megacloud
import com.mehdigm.cimastream4.extractors.Meownime
import com.mehdigm.cimastream4.extractors.MetaGnathTuggers
import com.mehdigm.cimastream4.extractors.MixDrop
import com.mehdigm.cimastream4.extractors.MixDropAg
import com.mehdigm.cimastream4.extractors.MixDropBz
import com.mehdigm.cimastream4.extractors.MixDropCh
import com.mehdigm.cimastream4.extractors.MixDropTo
import com.mehdigm.cimastream4.extractors.MixDropPs
import com.mehdigm.cimastream4.extractors.Mdy
import com.mehdigm.cimastream4.extractors.MixDropSi
import com.mehdigm.cimastream4.extractors.MxDropTo
import com.mehdigm.cimastream4.extractors.Movhide
import com.mehdigm.cimastream4.extractors.Moviehab
import com.mehdigm.cimastream4.extractors.MoviehabNet
import com.mehdigm.cimastream4.extractors.Moviesm4u
import com.mehdigm.cimastream4.extractors.Mp4Upload
import com.mehdigm.cimastream4.extractors.Multimovies
import com.mehdigm.cimastream4.extractors.Mvidoo
import com.mehdigm.cimastream4.extractors.MyVidPlay
import com.mehdigm.cimastream4.extractors.Mwish
import com.mehdigm.cimastream4.extractors.Namefacesnap
import com.mehdigm.cimastream4.extractors.Nameitweb
import com.mehdigm.cimastream4.extractors.NathanFromSubject
import com.mehdigm.cimastream4.extractors.Nekostream
import com.mehdigm.cimastream4.extractors.Nekowish
import com.mehdigm.cimastream4.extractors.Neonime7n
import com.mehdigm.cimastream4.extractors.Neonime8n
import com.mehdigm.cimastream4.extractors.Obeywish
import com.mehdigm.cimastream4.extractors.Odnoklassniki
import com.mehdigm.cimastream4.extractors.Odysseusa
import com.mehdigm.cimastream4.extractors.OkRuHTTP
import com.mehdigm.cimastream4.extractors.OkRuHTTPMobile
import com.mehdigm.cimastream4.extractors.OkRuSSL
import com.mehdigm.cimastream4.extractors.OkRuSSLMobile
import com.mehdigm.cimastream4.extractors.PeaceMakerst
import com.mehdigm.cimastream4.extractors.Peytonepre
import com.mehdigm.cimastream4.extractors.Pichive
import com.mehdigm.cimastream4.extractors.PixelDrain
import com.mehdigm.cimastream4.extractors.PixelDrainDev
import com.mehdigm.cimastream4.extractors.PlayLtXyz
import com.mehdigm.cimastream4.extractors.PlayRu
import com.mehdigm.cimastream4.extractors.PlayerVoxzer
import com.mehdigm.cimastream4.extractors.Playerwish
import com.mehdigm.cimastream4.extractors.Playmate
import com.mehdigm.cimastream4.extractors.Playmogo
import com.mehdigm.cimastream4.extractors.Rabbitstream
import com.mehdigm.cimastream4.extractors.RapidVid
import com.mehdigm.cimastream4.extractors.Rasacintaku
import com.mehdigm.cimastream4.extractors.SBfull
import com.mehdigm.cimastream4.extractors.Sbasian
import com.mehdigm.cimastream4.extractors.Sbface
import com.mehdigm.cimastream4.extractors.Sbflix
import com.mehdigm.cimastream4.extractors.Sblona
import com.mehdigm.cimastream4.extractors.Sblongvu
import com.mehdigm.cimastream4.extractors.Sbnet
import com.mehdigm.cimastream4.extractors.Sbrapid
import com.mehdigm.cimastream4.extractors.Sbsonic
import com.mehdigm.cimastream4.extractors.Sbspeed
import com.mehdigm.cimastream4.extractors.Sbthe
import com.mehdigm.cimastream4.extractors.SecvideoOnline
import com.mehdigm.cimastream4.extractors.Sendvid
import com.mehdigm.cimastream4.extractors.Server1uns
import com.mehdigm.cimastream4.extractors.SfastwishCom
import com.mehdigm.cimastream4.extractors.ShaveTape
import com.mehdigm.cimastream4.extractors.SibNet
import com.mehdigm.cimastream4.extractors.Simpulumlamerop
import com.mehdigm.cimastream4.extractors.Smoothpre
import com.mehdigm.cimastream4.extractors.Sobreatsesuyp
import com.mehdigm.cimastream4.extractors.Ssbstream
import com.mehdigm.cimastream4.extractors.StreamEmbed
import com.mehdigm.cimastream4.extractors.StreamHLS
import com.mehdigm.cimastream4.extractors.StreamM4u
import com.mehdigm.cimastream4.extractors.StreamSB
import com.mehdigm.cimastream4.extractors.StreamSB1
import com.mehdigm.cimastream4.extractors.StreamSB10
import com.mehdigm.cimastream4.extractors.StreamSB11
import com.mehdigm.cimastream4.extractors.StreamSB2
import com.mehdigm.cimastream4.extractors.StreamSB3
import com.mehdigm.cimastream4.extractors.StreamSB4
import com.mehdigm.cimastream4.extractors.StreamSB5
import com.mehdigm.cimastream4.extractors.StreamSB6
import com.mehdigm.cimastream4.extractors.StreamSB7
import com.mehdigm.cimastream4.extractors.StreamSB8
import com.mehdigm.cimastream4.extractors.StreamSB9
import com.mehdigm.cimastream4.extractors.StreamSilk
import com.mehdigm.cimastream4.extractors.StreamTape
import com.mehdigm.cimastream4.extractors.StreamTapeNet
import com.mehdigm.cimastream4.extractors.StreamTapeXyz
import com.mehdigm.cimastream4.extractors.Watchadsontape
import com.mehdigm.cimastream4.extractors.StreamWishExtractor
import com.mehdigm.cimastream4.extractors.StreamhideCom
import com.mehdigm.cimastream4.extractors.StreamhideTo
import com.mehdigm.cimastream4.extractors.Streamhub2
import com.mehdigm.cimastream4.extractors.Streamlare
import com.mehdigm.cimastream4.extractors.StreamoUpload
import com.mehdigm.cimastream4.extractors.Streamplay
import com.mehdigm.cimastream4.extractors.StreamRuby
import com.mehdigm.cimastream4.extractors.StreamRubyCom
import com.mehdigm.cimastream4.extractors.Streamsss
import com.mehdigm.cimastream4.extractors.Streamwish2
import com.mehdigm.cimastream4.extractors.Strwish
import com.mehdigm.cimastream4.extractors.Strwish2
import com.mehdigm.cimastream4.extractors.Supervideo
import com.mehdigm.cimastream4.extractors.Swdyu
import com.mehdigm.cimastream4.extractors.Swhoi
import com.mehdigm.cimastream4.extractors.TRsTX
import com.mehdigm.cimastream4.extractors.Tantifilm
import com.mehdigm.cimastream4.extractors.TauVideo
import com.mehdigm.cimastream4.extractors.Techinmind
import com.mehdigm.cimastream4.extractors.Tubeless
import com.mehdigm.cimastream4.extractors.Uasopt
import com.mehdigm.cimastream4.extractors.Up4FunTop
import com.mehdigm.cimastream4.extractors.Up4Stream
import com.mehdigm.cimastream4.extractors.Upstream
import com.mehdigm.cimastream4.extractors.UpstreamExtractor
import com.mehdigm.cimastream4.extractors.Uqload
import com.mehdigm.cimastream4.extractors.Uqload1
import com.mehdigm.cimastream4.extractors.Uqload2
import com.mehdigm.cimastream4.extractors.Uqloadcx
import com.mehdigm.cimastream4.extractors.Uqloadbz
import com.mehdigm.cimastream4.extractors.UqloadsXyz
import com.mehdigm.cimastream4.extractors.Urochsunloath
import com.mehdigm.cimastream4.extractors.Userload
import com.mehdigm.cimastream4.extractors.Userscloud
import com.mehdigm.cimastream4.extractors.Uservideo
import com.mehdigm.cimastream4.extractors.Videa
import com.mehdigm.cimastream4.extractors.Vicloud
import com.mehdigm.cimastream4.extractors.VidHidePro
import com.mehdigm.cimastream4.extractors.VidHidePro1
import com.mehdigm.cimastream4.extractors.VidHidePro2
import com.mehdigm.cimastream4.extractors.VidHidePro3
import com.mehdigm.cimastream4.extractors.VidHidePro4
import com.mehdigm.cimastream4.extractors.VidHidePro5
import com.mehdigm.cimastream4.extractors.VidHidePro6
import com.mehdigm.cimastream4.extractors.VidHideHub
import com.mehdigm.cimastream4.extractors.Ryderjet
import com.mehdigm.cimastream4.extractors.Streamcash
import com.mehdigm.cimastream4.extractors.Thebesthostertv
import com.mehdigm.cimastream4.extractors.VidChampions
import com.mehdigm.cimastream4.extractors.VidMoxy
import com.mehdigm.cimastream4.extractors.VidStack
import com.mehdigm.cimastream4.extractors.VideoSeyred
import com.mehdigm.cimastream4.extractors.Videzz
import com.mehdigm.cimastream4.extractors.Vidgomunime
import com.mehdigm.cimastream4.extractors.Vidgomunimesb
import com.mehdigm.cimastream4.extractors.VidhideExtractor
import com.mehdigm.cimastream4.extractors.Vidmoly
import com.mehdigm.cimastream4.extractors.Vidmolyme
import com.mehdigm.cimastream4.extractors.Vidmolyto
import com.mehdigm.cimastream4.extractors.Vidmolybiz
import com.mehdigm.cimastream4.extractors.Vido
import com.mehdigm.cimastream4.extractors.Vidoza
import com.mehdigm.cimastream4.extractors.VinovoSi
import com.mehdigm.cimastream4.extractors.VinovoTo
import com.mehdigm.cimastream4.extractors.VidNest
import com.mehdigm.cimastream4.extractors.VidaaraxCom
import com.mehdigm.cimastream4.extractors.VidaaraxNet
import com.mehdigm.cimastream4.extractors.Vidara
import com.mehdigm.cimastream4.extractors.VidaraSo
import com.mehdigm.cimastream4.extractors.Vidaraa
import com.mehdigm.cimastream4.extractors.Vidaratem
import com.mehdigm.cimastream4.extractors.Vidaraw
import com.mehdigm.cimastream4.extractors.Vidarax
import com.mehdigm.cimastream4.extractors.Vidavaca
import com.mehdigm.cimastream4.extractors.Vide0Net
import com.mehdigm.cimastream4.extractors.Vidmatrixa
import com.mehdigm.cimastream4.extractors.Vids
import com.mehdigm.cimastream4.extractors.Vidsonic
import com.mehdigm.cimastream4.extractors.Vixeo
import com.mehdigm.cimastream4.extractors.VkExtractor
import com.mehdigm.cimastream4.extractors.Voe
import com.mehdigm.cimastream4.extractors.Voe1
import com.mehdigm.cimastream4.extractors.Voe2
import com.mehdigm.cimastream4.extractors.Vtbe
import com.mehdigm.cimastream4.extractors.Wibufile
import com.mehdigm.cimastream4.extractors.WishembedPro
import com.mehdigm.cimastream4.extractors.Wishfast
import com.mehdigm.cimastream4.extractors.Wishonly
import com.mehdigm.cimastream4.extractors.XStreamCdn
import com.mehdigm.cimastream4.extractors.Xenolyzb
import com.mehdigm.cimastream4.extractors.Yipsu
import com.mehdigm.cimastream4.extractors.YourUpload
import com.mehdigm.cimastream4.extractors.YoutubeExtractor
import com.mehdigm.cimastream4.extractors.YoutubeMobileExtractor
import com.mehdigm.cimastream4.extractors.YoutubeNoCookieExtractor
import com.mehdigm.cimastream4.extractors.YoutubeShortLinkExtractor
import com.mehdigm.cimastream4.extractors.Yufiles
import com.mehdigm.cimastream4.extractors.Yuguaab
import com.mehdigm.cimastream4.extractors.Zplayer
import com.mehdigm.cimastream4.extractors.ZplayerV2
import com.mehdigm.cimastream4.extractors.Ztreamhub
import com.mehdigm.cimastream4.mvvm.logError
import com.mehdigm.cimastream4.utils.Coroutines.atomicListOf
import io.ktor.http.Url
import io.ktor.http.decodeURLPart
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlin.coroutines.cancellation.CancellationException
import kotlin.uuid.Uuid
import kotlin.uuid.toJavaUuid
import kotlin.uuid.toKotlinUuid

/**
 * For use in the ConcatenatingMediaSource.
 * If features are missing (headers), please report and we can add it.
 * @param durationUs use Long.toUs() for easier input
 * */
data class PlayListItem(
    val url: String,
    val durationUs: Long,
)

/**
 * Converts Seconds to MicroSeconds, multiplication by 1_000_000
 * */
fun Long.toUs(): Long {
    return this * 1_000_000
}

/**
 * If your site has an unorthodox m3u8-like system where there are multiple smaller videos concatenated
 * use this.
 * */
@Suppress("DEPRECATION")
data class ExtractorLinkPlayList(
    override val source: String,
    override val name: String,
    val playlist: List<PlayListItem>,
    override var referer: String,
    override var quality: Int,
    override var headers: Map<String, String> = mapOf(),
    /** Used for getExtractorVerifierJob() */
    override var extractorData: String? = null,
    override var type: ExtractorLinkType,
    override var audioTracks: List<AudioFile> = emptyList(),
) : ExtractorLink(
    source = source,
    name = name,
    url = "",
    referer = referer,
    quality = quality,
    headers = headers,
    extractorData = extractorData,
    type = type,
    audioTracks = audioTracks
) {
    constructor(
        source: String,
        name: String,
        playlist: List<PlayListItem>,
        referer: String,
        quality: Int,
        isM3u8: Boolean = false,
        headers: Map<String, String> = mapOf(),
        extractorData: String? = null,
    ) : this(
        source = source,
        name = name,
        playlist = playlist,
        referer = referer,
        quality = quality,
        type = if (isM3u8) ExtractorLinkType.M3U8 else ExtractorLinkType.VIDEO,
        headers = headers,
        extractorData = extractorData,
    )
}

/** Metadata about the file type used for downloads and exoplayer hint,
 * if you respond with the wrong one the file will fail to download or be played */
enum class ExtractorLinkType {
    /** Single stream of bytes no matter the actual file type */
    VIDEO,

    /** Split into several .ts files, has support for encrypted m3u8s */
    M3U8,

    /** Like m3u8 but uses xml, currently no download support */
    DASH,

    /** No support at the moment */
    TORRENT,

    /** No support at the moment */
    MAGNET;

    // See https://www.iana.org/assignments/media-types/media-types.xhtml
    @JsonIgnore
    fun getMimeType(): String {
        return when (this) {
            VIDEO -> "video/mp4"
            M3U8 -> "application/x-mpegURL"
            DASH -> "application/dash+xml"
            TORRENT -> "application/x-bittorrent"
            MAGNET -> "application/x-bittorrent"
        }
    }
}

private fun inferTypeFromUrl(url: String): ExtractorLinkType {
    val path = try {
        Url(url).encodedPath.decodeURLPart()
    } catch (_: Throwable) {
        // don't log magnet links as errors
        null
    }
    return when {
        path?.endsWith(".m3u8") == true -> ExtractorLinkType.M3U8
        path?.endsWith(".mpd") == true -> ExtractorLinkType.DASH
        path?.endsWith(".torrent") == true -> ExtractorLinkType.TORRENT
        url.startsWith("magnet:") -> ExtractorLinkType.MAGNET
        else -> ExtractorLinkType.VIDEO
    }
}

val INFER_TYPE: ExtractorLinkType? = null

/**
 * [Uuid] for the ClearKey DRM scheme.
 *
 *
 * ClearKey is supported on Android devices running Android 5.0 (API Level 21) and up.
 */
@Prerelease
val CLEARKEY_DRM_UUID = Uuid.fromLongs(-0x1d8e62a7567a4c37L, 0x781AB030AF78D30EL)

/**
 * [Uuid] for the Widevine DRM scheme.
 *
 *
 * Widevine is supported on Android devices running Android 4.3 (API Level 18) and up.
 */
@Prerelease
val WIDEVINE_DRM_UUID = Uuid.fromLongs(-0x121074568629b532L, -0x5c37d8232ae2de13L)

/**
 * [Uuid] for the PlayReady DRM scheme.
 *
 *
 * PlayReady is supported on all AndroidTV devices. Note that most other Android devices do not
 * provide PlayReady support.
 */
@Prerelease
val PLAYREADY_DRM_UUID = Uuid.fromLongs(-0x65fb0f8667bfbd7aL, -0x546d19a41f77a06bL)

// Deprecate after next stable

// @Deprecated("Use CLEARKEY_DRM_UUID", ReplaceWith("CLEARKEY_DRM_UUID"), level = DeprecationLevel.WARNING)
val CLEARKEY_UUID = CLEARKEY_DRM_UUID.toJavaUuid()

// @Deprecated("Use WIDEVINE_DRM_UUID", ReplaceWith("WIDEVINE_DRM_UUID"), level = DeprecationLevel.WARNING)
val WIDEVINE_UUID = WIDEVINE_DRM_UUID.toJavaUuid()

// @Deprecated("Use PLAYREADY_DRM_UUID", ReplaceWith("PLAYREADY_DRM_UUID"), level = DeprecationLevel.WARNING)
val PLAYREADY_UUID = PLAYREADY_DRM_UUID.toJavaUuid()

suspend fun newExtractorLink(
    source: String,
    name: String,
    url: String,
    type: ExtractorLinkType? = null,
    initializer: suspend ExtractorLink.() -> Unit = { }
): ExtractorLink {

    @Suppress("DEPRECATION_ERROR")
    val builder =
        ExtractorLink(
            source = source,
            name = name,
            url = url,
            type = type ?: INFER_TYPE
        )

    builder.initializer()
    return builder
}

// Deprecate after next stable
/* @Deprecated(
    message = "Use Kotlin Uuid (kotlin.uuid.Uuid) instead of Java UUID.",
    level = DeprecationLevel.WARNING,
) */
suspend fun newDrmExtractorLink(
    source: String,
    name: String,
    url: String,
    type: ExtractorLinkType? = null,
    uuid: java.util.UUID,
    initializer: suspend DrmExtractorLink.() -> Unit = { }
): DrmExtractorLink {
    @Suppress("DEPRECATION_ERROR")
    val builder =
        DrmExtractorLink(
            source = source,
            name = name,
            url = url,
            uuid = uuid.toKotlinUuid(),
            type = type ?: INFER_TYPE
        )

    builder.initializer()
    return builder
}

@Prerelease
suspend fun newDrmExtractorLink(
    source: String,
    name: String,
    url: String,
    type: ExtractorLinkType? = null,
    uuid: Uuid,
    initializer: suspend DrmExtractorLink.() -> Unit = {},
): DrmExtractorLink {
    @Suppress("DEPRECATION_ERROR")
    val builder =
        DrmExtractorLink(
            source = source,
            name = name,
            url = url,
            uuid = uuid,
            type = type ?: INFER_TYPE
        )

    builder.initializer()
    return builder
}

/** Class holds extracted DRM media info to be passed to the player.
 * @property source Name of the media source, appears on player layout.
 * @property name Title of the media, appears on player layout.
 * @property url Url string of media file
 * @property referer Referer that will be used by network request.
 * @property quality Quality of the media file
 * @property headers Headers <String, String> map that will be used by network request.
 * @property extractorData Used for getExtractorVerifierJob()
 * @property type the type of the media, use [INFER_TYPE] if you want to auto infer the type from the url
 * @property kid  Base64 value of The KID element (Key Id) contains the identifier of the key associated with a license.
 * @property key Base64 value of Key to be used to decrypt the media file.
 * @property uuid Drm [Uuid] [WIDEVINE_DRM_UUID], [PLAYREADY_DRM_UUID], [CLEARKEY_DRM_UUID] (by default) .. etc
 * @property kty Key type "oct" (octet sequence) by default
 * @property keyRequestParameters Parameters that will used to request the key.
 * @see newDrmExtractorLink
 * */
@Suppress("DEPRECATION")
open class DrmExtractorLink private constructor(
    override val source: String,
    override val name: String,
    override val url: String,
    override var referer: String,
    override var quality: Int,
    override var headers: Map<String, String> = mapOf(),
    /** Used for getExtractorVerifierJob() */
    override var extractorData: String? = null,
    override var type: ExtractorLinkType,
    open var kid: String? = null,
    open var key: String? = null,
    open var uuid: Uuid,
    open var kty: String? = null,
    open var keyRequestParameters: HashMap<String, String>,
    open var licenseUrl: String? = null,
    override var audioTracks: List<AudioFile> = emptyList(),
) : ExtractorLink(
    source, name, url, referer, quality, headers, extractorData, type, audioTracks
) {
    @Deprecated("Use newDrmExtractorLink", level = DeprecationLevel.ERROR)
    constructor(
        source: String,
        name: String,
        url: String,
        referer: String? = null,
        quality: Int? = null,
        /** the type of the media, use INFER_TYPE if you want to auto infer the type from the url */
        type: ExtractorLinkType? = INFER_TYPE,
        headers: Map<String, String> = mapOf(),
        /** Used for getExtractorVerifierJob() */
        extractorData: String? = null,
        kid: String? = null,
        key: String? = null,
        uuid: Uuid = CLEARKEY_DRM_UUID,
        kty: String? = "oct",
        keyRequestParameters: HashMap<String, String> = hashMapOf(),
        licenseUrl: String? = null,
    ) : this(
        source = source,
        name = name,
        url = url,
        referer = referer ?: "",
        quality = quality ?: Qualities.Unknown.value,
        headers = headers,
        extractorData = extractorData,
        type = type ?: inferTypeFromUrl(url),
        kid = kid,
        key = key,
        uuid = uuid,
        keyRequestParameters = keyRequestParameters,
        kty = kty,
        licenseUrl = licenseUrl,
    )

    @Deprecated("Use newDrmExtractorLink", level = DeprecationLevel.ERROR)
    constructor(
        source: String,
        name: String,
        url: String,
        referer: String,
        quality: Int,
        /** the type of the media, use INFER_TYPE if you want to auto infer the type from the url */
        type: ExtractorLinkType?,
        headers: Map<String, String> = mapOf(),
        /** Used for getExtractorVerifierJob() */
        extractorData: String? = null,
        kid: String? = null,
        key: String? = null,
        uuid: Uuid = CLEARKEY_DRM_UUID,
        kty: String? = "oct",
        keyRequestParameters: HashMap<String, String> = hashMapOf(),
        licenseUrl: String? = null,
    ) : this(
        source = source,
        name = name,
        url = url,
        referer = referer,
        quality = quality,
        headers = headers,
        extractorData = extractorData,
        type = type ?: inferTypeFromUrl(url),
        kid = kid,
        key = key,
        uuid = uuid,
        keyRequestParameters = keyRequestParameters,
        kty = kty,
        licenseUrl = licenseUrl,
    )

    @Deprecated(message = "Use Kotlin Uuid", level = DeprecationLevel.HIDDEN)
    fun setUuid(uuid: java.util.UUID) {
        this.uuid = uuid.toKotlinUuid()
    }

    @Deprecated(message = "Use Kotlin Uuid", level = DeprecationLevel.HIDDEN)
    fun getUuid(): java.util.UUID = this.uuid.toJavaUuid()
}

/** Class holds extracted media info to be passed to the player.
 * @property source Name of the media source, appears on player layout.
 * @property name Title of the media, appears on player layout.
 * @property url Url string of media file
 * @property referer Referer that will be used by network request.
 * @property quality Quality of the media file
 * @property headers Headers <String, String> map that will be used by network request.
 * @property extractorData Used for getExtractorVerifierJob()
 * @property type Extracted link type (Video, M3u8, Dash, Torrent or Magnet)
 * @property audioTracks List of separate audio tracks that can be used with this video
 * @see newExtractorLink
 * */
@Serializable
open class ExtractorLink
@Deprecated("Use newExtractorLink", level = DeprecationLevel.WARNING)
constructor(
    @SerialName("source") open val source: String,
    @SerialName("name") open val name: String,
    @SerialName("url") override val url: String,
    @SerialName("referer") override var referer: String,
    @SerialName("quality") open var quality: Int,
    @SerialName("headers") override var headers: Map<String, String> = mapOf(),
    /** Used for getExtractorVerifierJob() */
    @SerialName("extractorData") open var extractorData: String? = null,
    @SerialName("type") open var type: ExtractorLinkType,
    /** List of separate audio tracks that can be merged with this video */
    @SerialName("audioTracks") open var audioTracks: List<AudioFile> = emptyList(),
) : IDownloadableMinimum {
    @get:JsonIgnore val isM3u8: Boolean get() = type == ExtractorLinkType.M3U8
    @get:JsonIgnore val isDash: Boolean get() = type == ExtractorLinkType.DASH

    // Cached video size
    @Transient private var videoSize: Long? = null

    /**
     * Get video size in bytes with one head request. Only available for ExtractorLinkType.Video
     * @param timeoutSeconds timeout of the head request.
     */
    suspend fun getVideoSize(timeoutSeconds: Long = 3L): Long? {
        // Content-Length is not applicable to other types of formats
        if (this.type != ExtractorLinkType.VIDEO) return null

        videoSize = videoSize ?: runCatching {
            val response =
                app.head(this.url, headers = headers, referer = referer, timeout = timeoutSeconds)
            response.headers["Content-Length"]?.toLong()
        }.getOrNull()

        return videoSize
    }

    @JsonIgnore
    fun getAllHeaders(): Map<String, String> {
        if (referer.isBlank()) {
            return headers
        } else if (headers.keys.none { it.equals("referer", ignoreCase = true) }) {
            return headers + mapOf("referer" to referer)
        }
        return headers
    }

    @Suppress("DEPRECATION")
    @Deprecated("Use newExtractorLink", level = DeprecationLevel.ERROR)
    constructor(
        source: String,
        name: String,
        url: String,
        referer: String? = null,
        quality: Int? = null,
        /** the type of the media, use INFER_TYPE if you want to auto infer the type from the url */
        type: ExtractorLinkType? = INFER_TYPE,
        headers: Map<String, String> = mapOf(),
        /** Used for getExtractorVerifierJob() */
        extractorData: String? = null,
    ) : this(
        source = source,
        name = name,
        url = url,
        referer = referer ?: "",
        quality = quality ?: Qualities.Unknown.value,
        headers = headers,
        extractorData = extractorData,
        type = type ?: inferTypeFromUrl(url)
    )

    @Suppress("DEPRECATION")
    @Deprecated("Use newExtractorLink", level = DeprecationLevel.ERROR)
    constructor(
        source: String,
        name: String,
        url: String,
        referer: String,
        quality: Int,
        /** the type of the media, use INFER_TYPE if you want to auto infer the type from the url */
        type: ExtractorLinkType?,
        headers: Map<String, String> = mapOf(),
        /** Used for getExtractorVerifierJob() */
        extractorData: String? = null,
    ) : this(
        source = source,
        name = name,
        url = url,
        referer = referer,
        quality = quality,
        headers = headers,
        extractorData = extractorData,
        type = type ?: inferTypeFromUrl(url)
    )

    /**
     * Old constructor without isDash, allows for backwards compatibility with extensions.
     * Should be removed after all extensions have updated their cimastream.jar
     **/
    @Suppress("DEPRECATION_ERROR")
    @Deprecated("Use newExtractorLink", level = DeprecationLevel.ERROR)
    constructor(
        source: String,
        name: String,
        url: String,
        referer: String,
        quality: Int,
        isM3u8: Boolean = false,
        headers: Map<String, String> = mapOf(),
        /** Used for getExtractorVerifierJob() */
        extractorData: String? = null
    ) : this(source, name, url, referer, quality, isM3u8, headers, extractorData, false)

    @Suppress("DEPRECATION")
    @Deprecated("Use newExtractorLink", level = DeprecationLevel.ERROR)
    constructor(
        source: String,
        name: String,
        url: String,
        referer: String,
        quality: Int,
        isM3u8: Boolean = false,
        headers: Map<String, String> = mapOf(),
        /** Used for getExtractorVerifierJob() */
        extractorData: String? = null,
        isDash: Boolean,
    ) : this(
        source = source,
        name = name,
        url = url,
        referer = referer,
        quality = quality,
        headers = headers,
        extractorData = extractorData,
        type = if (isDash) ExtractorLinkType.DASH else if (isM3u8) ExtractorLinkType.M3U8 else ExtractorLinkType.VIDEO
    )

    override fun toString(): String {
        return "ExtractorLink(name=$name, url=$url, referer=$referer, type=$type)"
    }
}

/**
 * Removes https:// and www.
 * To match urls regardless of schema, perhaps Url() can be used?
 */
val schemaStripRegex = Regex("""^(https:|)//(www\.|)""")

enum class Qualities(var value: Int, val defaultPriority: Int) {
    Unknown(400, 4),
    P144(144, 0), // 144p
    P240(240, 2), // 240p
    P360(360, 3), // 360p
    P480(480, 4), // 480p
    P720(720, 5), // 720p
    P1080(1080, 6), // 1080p
    P1440(1440, 7), // 1440p
    P2160(2160, 8); // 4k or 2160p

    companion object {
        fun getStringByInt(qual: Int?): String {
            return when (qual) {
                0 -> "Auto"
                Unknown.value -> ""
                P2160.value -> "4K"
                null -> ""
                else -> "${qual}p"
            }
        }

        fun getStringByIntFull(quality: Int): String {
            return when (quality) {
                0 -> "Auto"
                Unknown.value -> "Unknown"
                P2160.value -> "4K"
                else -> "${quality}p"
            }
        }
    }
}

fun getQualityFromName(qualityName: String?): Int {
    if (qualityName == null)
        return Qualities.Unknown.value

    val match = qualityName.lowercase().replace("p", "").trim()
    return when (match) {
        "4k" -> Qualities.P2160
        else -> null
    }?.value ?: match.toIntOrNull() ?: Qualities.Unknown.value
}

private val packedRegex = Regex("""eval\(function\(p,a,c,k,e,.*\)\)""")
fun getPacked(string: String): String? {
    return packedRegex.find(string)?.value
}

fun getAndUnpack(string: String): String {
    val packedText = getPacked(string)
    return JsUnpacker(packedText).unpack() ?: string
}

suspend fun unshortenLinkSafe(url: String): String {
    return try {
        if (ShortLink.isShortLink(url))
            ShortLink.unshorten(url)
        else url
    } catch (e: Exception) {
        logError(e)
        url
    }
}

suspend fun loadExtractor(
    url: String,
    subtitleCallback: (SubtitleFile) -> Unit,
    callback: (ExtractorLink) -> Unit
): Boolean {
    return loadExtractor(
        url = url,
        referer = null,
        subtitleCallback = subtitleCallback,
        callback = callback
    )
}


/**
 * Tries to load the appropriate extractor based on link, returns true if any extractor is loaded.
 * */
@Throws(CancellationException::class)
suspend fun loadExtractor(
    url: String,
    referer: String? = null,
    subtitleCallback: (SubtitleFile) -> Unit,
    callback: (ExtractorLink) -> Unit
): Boolean {
    // Ensure this coroutine has not timed out
    coroutineScope { ensureActive() }

    val currentUrl = unshortenLinkSafe(url)
    val compareUrl = currentUrl.lowercase().replace(schemaStripRegex, "")

    // Iterate in reverse order so the new registered ExtractorApi takes priority
    for (index in extractorApis.lastIndex downTo 0) {
        val extractor = extractorApis[index]
        if (compareUrl.startsWith(extractor.mainUrl.replace(schemaStripRegex, ""))) {
            try {
                extractor.getUrl(currentUrl, referer, subtitleCallback, callback)
            } catch (e: Exception) {
                logError(e)
                // Rethrow if we have timed out
                if (e is CancellationException) {
                    throw e
                }
            }
            return true
        }
    }

    // this is to match mirror domains - like example.com, example.net
    for (index in extractorApis.lastIndex downTo 0) {
        val extractor = extractorApis[index]
        if (Levenshtein.partialRatio(
                extractor.mainUrl,
                currentUrl
            ) > 80
        ) {
            try {
                extractor.getUrl(currentUrl, referer, subtitleCallback, callback)
            } catch (e: Exception) {
                logError(e)
                // Rethrow if we have timed out
                if (e is CancellationException) {
                    throw e
                }
            }
            return true
        }
    }

    return false
}

val extractorApis: AtomicMutableList<ExtractorApi> = atomicListOf(
    //AllProvider(),
    Mp4Upload(),
    StreamTape(),
    StreamTapeNet(),
    ShaveTape(),
    StreamTapeXyz(),
    Watchadsontape(),

    //mixdrop extractors
    MixDropBz(),
    MixDropCh(),
    MixDropTo(),
    MixDropAg(),
    MixDrop(),
    MixDropPs(),
    Mdy(),
    MxDropTo(),
    MixDropSi(),

    XStreamCdn(),

    StreamSB(),
    Sblona(),
    Vidgomunimesb(),
    StreamSilk(),
    StreamSB1(),
    StreamSB2(),
    StreamSB3(),
    StreamSB4(),
    StreamSB5(),
    StreamSB6(),
    StreamSB7(),
    StreamSB8(),
    StreamSB9(),
    StreamSB10(),
    StreamSB11(),
    SBfull(),
    // Streamhub(), cause Streamhub2() works
    Streamhub2(),
    Ssbstream(),
    Sbthe(),
    Vidgomunime(),
    Sbflix(),
    Streamsss(),
    Sbspeed(),
    Sbsonic(),
    Sbface(),
    Sbrapid(),
    Lvturbo(),

    Fastream(),
    Videa(),
    FEmbed(),
    FeHD(),
    Fplayer(),
    DBfilm(),
    Luxubu(),
    LayarKaca(),
    Rasacintaku(),
    FEnet(),
    Kotakajair(),
    Cdnplayer(),
    //  WatchSB(), 'cause StreamSB.kt works
    Uqload(),
    Uqload1(),
    Uqload2(),
    Uqloadcx(),
    Uqloadbz(),
    Evoload(),
    Evoload1(),
    UpstreamExtractor(),

    Odnoklassniki(),
    TauVideo(),
    SibNet(),
    ContentX(),
    Hotlinger(),
    FourCX(),
    PlayRu(),
    FourPlayRu(),
    Pichive(),
    FourPichive(),
    HDMomPlayer(),
    HDPlayerSystem(),
    VideoSeyred(),
    PeaceMakerst(),
    HDStreamAble(),
    RapidVid(),
    TRsTX(),
    VidMoxy(),
    Sobreatsesuyp(),
    PixelDrain(),
    PixelDrainDev(),
    MailRu(),

    OkRuSSL(),
    OkRuSSLMobile(),
    OkRuHTTP(),
    OkRuHTTPMobile(),
    Sendvid(),

    // dood extractors
    DoodCxExtractor(),
    DoodPmExtractor(),
    DoodToExtractor(),
    DoodSoExtractor(),
    DoodLaExtractor(),
    Dooood(),
    D0000d(),
    D000dCom(),
    DoodstreamCom(),
    DoodWsExtractor(),
    DoodShExtractor(),
    DoodWatchExtractor(),
    DoodWfExtractor(),
    DoodYtExtractor(),
    Doodspro(),
    Dsvplay(),

    // GenericM3U8(),
    Zplayer(),
    ZplayerV2(),
    Upstream(),

    Maxstream(),
    Tantifilm(),
    Userload(),
    Supervideo(),
    Streamcash(),

    // StreamSB.kt works
    //  SBPlay(),
    //  SBPlay1(),
    //  SBPlay2(),

    PlayerVoxzer(),

    Blogger(),
    YourUpload(),

    Hxfile(),
    KotakAnimeid(),
    Neonime8n(),
    Neonime7n(),
    Yufiles(),
    Aico(),

    JWPlayer(),
    Meownime(),
    DesuArcg(),
    DesuOdchan(),
    DesuOdvip(),
    DesuDrive(),


    Keephealth(),
    Sbnet(),
    Sbasian(),
    Sblongvu(),
    Fembed9hd(),
    StreamM4u(),
    Krakenfiles(),
    Gofile(),
    Vicloud(),
    Uservideo(),
    Userscloud(),
    HubuCloud(),

    Movhide(),
    StreamhideCom(),
    StreamhideTo(),
    Wibufile(),
    FileMoonIn(),
    Moviesm4u(),
    Filesim(),
    Multimoviesshg(),
    Ahvsh(),
    Guccihide(),
    FileMoon(),
    FileMoonSx(),
    FilemoonV2(),

    Vido(),
    Linkbox(),
    Acefile(),
    Embedgram(),
    Mvidoo(),
    Streamplay(),
    Vidmoly(),
    Vidmolyme(),
    Vidmolyto(),
    Vidmolybiz(),
    Voe(),
    Voe1(),
    Voe2(),
    Tubeless(),
    Moviehab(),
    MoviehabNet(),
    Jeniusplay(),
    StreamoUpload(),
    Vidara(),
    Vidavaca(),
    Vidaraa(),
    Vidaraw(),
    Vidarax(),
    VidaraSo(),
    Vidaratem(),
    VidaaraxCom(),
    VidaaraxNet(),
    Odysseusa(),
    Handfacesnap(),
    Namefacesnap(),
    Thebesthostertv(),
    Vidmatrixa(),
    VidChampions(),
    Antarcticadocs(),
    Nameitweb(),

    GamoVideo(),
    Gdriveplayerapi(),
    Gdriveplayerapp(),
    Gdriveplayerfun(),
    Gdriveplayerio(),
    Gdriveplayerme(),
    Gdriveplayerbiz(),
    Gdriveplayerorg(),
    Gdriveplayerus(),
    Gdriveplayerco(),
    GoodstreamExtractor(),
    Gdriveplayer(),
    DatabaseGdrive(),
    DatabaseGdrive2(),
    Mediafire(),

    YoutubeExtractor(),
    YoutubeShortLinkExtractor(),
    YoutubeMobileExtractor(),
    YoutubeNoCookieExtractor(),
    Streamlare(),
    PlayLtXyz(),

    Cda(),
    Dailymotion(),
    Ztreamhub(),
    Rabbitstream(),
    Dokicloud(),
    Megacloud(),
    VidhideExtractor(),
    VidHidePro(),
    VidHidePro1(),
    VidHidePro2(),
    VidHidePro3(),
    VidHidePro4(),
    VidHidePro5(),
    VidHidePro6(),
    VidHideHub(),
    Ryderjet(),
    VidNest(),
    Dhtpre(),

    // CineMM Redirects
    Dhcplay(),
    HglinkTo(),

    // CineMM mirrors
    HgplayCDN(),
    Habetar(),
    Yuguaab(),
    Guxhag(),
    Auvexiug(),
    Xenolyzb(),
    Haxloppd(),
    Cavanhabg(),
    Dumbalag(),
    Uasopt(),

    Smoothpre(),
    Peytonepre(),
    LuluStream(),
    Lulustream1(),
    Lulustream2(),
    Luluvdoo(),
    StreamWishExtractor(),
    StreamHLS(),
    BigwarpIO(),
    BigwarpArt(),
    BgwpCC(),
    WishembedPro(),
    CdnwishCom(),
    FlaswishCom(),
    SfastwishCom(),
    Playerwish(),
    StreamEmbed(),
    EmturbovidExtractor(),
    Vtbe(),
    SecvideoOnline(),
    FsstOnline(),
    CsstOnline(),
    DsstOnline(),
    Simpulumlamerop(),
    Urochsunloath(),
    NathanFromSubject(),
    Yipsu(),
    MetaGnathTuggers(),
    Geodailymotion(),
    Mwish(),
    Hgcloudto(),
    Dwish(),
    Ewish(),
    Kswplayer(),
    Wishfast(),
    Streamwish2(),
    Strwish(),
    Strwish2(),
    Awish(),
    Obeywish(),
    Jodwish(),
    Swhoi(),
    Multimovies(),
    UqloadsXyz(),
    Doodporn(),
    Asnwish(),
    Nekowish(),
    Nekostream(),
    Swdyu(),
    Wishonly(),
    Ds2play(),
    Ds2video(),
    Vidsonic(),
    Vixeo(),
    InternetArchive(),
    VidStack(),
    GDMirrorbot(),
    Techinmind(),
    Server1uns(),
    VinovoSi(),
    VinovoTo(),
    Vidoza(),
    Videzz(),
    CloudMailRu(),
    HubCloud(),
    VkExtractor(),
    Bysezejataos(),
    ByseSX(),
    ByseVepoin(),
    ByseBuho(),
    MyVidPlay(),
    Playmogo(),
    Vide0Net(),
    Up4Stream(),
    Up4FunTop(),
    GUpload(),
    HlsWish(),
    ByseQekaho(),
    Flyfile(),
    Firestream(),
    FirestreamSite(),
    Vids(),
    Playmate(),
    Hexload(),
    StreamRuby(),
    StreamRubyCom(),
)


fun getExtractorApiFromName(name: String): ExtractorApi {
    for (api in extractorApis) {
        if (api.name == name) return api
    }
    return extractorApis[0]
}

fun requireReferer(name: String): Boolean {
    return getExtractorApiFromName(name).requiresReferer
}

fun httpsify(url: String): String {
    return if (url.startsWith("//")) "https:$url" else url
}

suspend fun getPostForm(requestUrl: String, html: String): String? {
    val document = Ksoup.parse(html)
    val inputs = document.select("Form > input")
    if (inputs.size < 4) return null
    var op: String? = null
    var id: String? = null
    var mode: String? = null
    var hash: String? = null

    for (input in inputs) {
        val value = input.attr("value")
        when (input.attr("name")) {
            "op" -> op = value
            "id" -> id = value
            "mode" -> mode = value
            "hash" -> hash = value
            else -> Unit
        }
    }
    if (op == null || id == null || mode == null || hash == null) {
        return null
    }
    delay(5000) // ye this is needed, wont work with 0 delay

    return app.post(
        requestUrl,
        headers = mapOf(
            "content-type" to "application/x-www-form-urlencoded",
            "referer" to requestUrl,
            "user-agent" to USER_AGENT,
            "accept" to "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9"
        ),
        data = mapOf("op" to op, "id" to id, "mode" to mode, "hash" to hash)
    ).text
}

fun ExtractorApi.fixUrl(url: String): String {
    if (url.startsWith("http") ||
        // Do not fix JSON objects when passed as urls.
        url.startsWith("{\"")
    ) {
        return url
    }
    if (url.isEmpty()) {
        return ""
    }

    val startsWithNoHttp = url.startsWith("//")
    if (startsWithNoHttp) {
        return "https:$url"
    } else {
        if (url.startsWith('/')) {
            return mainUrl + url
        }
        return "$mainUrl/$url"
    }
}

abstract class ExtractorApi {
    abstract val name: String
    abstract val mainUrl: String
    abstract val requiresReferer: Boolean

    /** Determines which plugin a given provider is from. This is the full path to the plugin. */
    var sourcePlugin: String? = null

    //suspend fun getSafeUrl(url: String, referer: String? = null): List<ExtractorLink>? {
    //    return safeAsync { getUrl(url, referer) }
    //}

    // this is the new extractorapi, override to add subtitles and stuff
    @Throws
    open suspend fun getUrl(
        url: String,
        referer: String? = null,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ) {
        getUrl(url, referer)?.forEach(callback)
    }

    suspend fun getSafeUrl(
        url: String,
        referer: String? = null,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ) {
        try {
            getUrl(url, referer, subtitleCallback, callback)
        } catch (e: Exception) {
            logError(e)
        }
    }

    /**
     * Will throw errors, use getSafeUrl if you don't want to handle the exception yourself
     */
    @Throws
    open suspend fun getUrl(url: String, referer: String? = null): List<ExtractorLink>? {
        return emptyList()
    }

    open fun getExtractorUrl(id: String): String {
        return id
    }
}
