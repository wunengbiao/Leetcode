package leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2017/2/9.
 */
public class Solution402 {
    String res = "";

    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        List<Character> nums = new ArrayList<>();
        for (Character c : num.toCharArray()) {
            nums.add(c);
        }
        removeKdigits(nums,k);
        int i = 0;
        while (i < res.length()) {
            if (res.charAt(i) != '0') break;
            i++;
        }
        res = res.substring(i);
        if (res.equals("")) return "0";
        return res;
    }

    public void removeKdigits(List<Character> nums, int k) {

        for (int count = 0; count < k; count++) {
            int i = 0;
            while (i < nums.size()) {
                if (i == nums.size() - 1) {
                    nums.remove(i);
                    break;
                } else if (nums.get(i) > nums.get(i + 1)) {
                    nums.remove(i);
                    break;
                } else {
                    i++;
                }
            }
        }

        for(Character c:nums){
            res+=c;
        }

    }

    public static void main(String[] args) {
        Solution402 s = new Solution402();
        String test1 = "99641436378815361153471302158193420182863684789411484994976484827114595334610042544056442370530816060833617030976813134098793056155103202008549344446519354408307307071055065112738442020228471569394796174150323080161225901964338837341524253243218509500254619223683091799365677720582389568156585225666197123093377871100002481402486219837255411382162499321193416524972275273471969155848742457476556433737281147710021781210134765321761285612276511917324552585569882156635094670362653567596144728653795007023230933817566104488637696450166087905100823699425798763598444326069357052842379918535855296915760054459317433521878778171811081076593166663090948029793113626852462712388116483774713426183911481230884393594249331828165503798269634244430773693033882708000249632850148799859322024693146577635543114657662418998860517525989192973250701631765598465053097616804817344343895016724561947860836117504915797011185132674255278236597746042138768473723059825948301565719437610732907662545499042953499866813741157301003371005200992314265077531029437948931255617153417148822355928318598517533241719641002712204874161001604269216566928220767474713135516717997491363360204764154264989004671363541097433484822118483642107547658581450616821769964767032521138851570822729134762460014265433227201724724004338494552397280090568164786109721571436206198382814849033856987338787473335772666933218810822482848994610491705665155516384799459418594559136827941106387689501641851101743298582575466303864906673788496628288920867422193950180810131396612913851112593807649152972068279299934113463669714575613645929365652921808836725682390026075559320995704880149764583379697505303474550029059828116836469203370428449330442281563135568935742669243344218603994417955703485059862132359688776290378210392955310785874528205203788559715493852405991380290274268143557970398441851157977520689440430265144029789788511042795879174567381358510694749512938934687979305099149575464220629804942550564164786808856897809863824121659548034395539735407069279457678613909222371848892294754933299091164656871086269084324529512544747434123547189729993758337622038098699448815701644934651292719067683227727438808955969543542319197883567369733867364250353136697865107182282929655918362211832327827571354787535611501731943856155003853732339819594939524719169561110698571676562329360803282215467534058504728127731515598941143637827010955579092451405821352126706550438315176049692316210490899702613078702535716735901806171522853021035597316703390478571485677998207922773938829371460838611214446417528913575284776737837046439695408523434414916342979688820197836458637694991540998291690345194205452439239827382953039810367712244590155940394387554911786652478111954297185544106384174592451680875083737874735810068767866214924634885513828808880161930987276602570872860752119813042414550396358433893592777541756673206882876746731707766966268096104320061937913505893028833592137540396064375155513979764728180927083060481127522118240026140625647313783901073938419240249929000962722034273952683635919540169732220854978101308126446671885186032295490845060116567165945677975672981321362161949418405852378788584602802612398876874288293756055559457538271197205867506313677160755990736347314715042607243878693780144368083800080967842966193539823770427967091132770230485036143223363387876244958899577538069175123004651952588711287008791159682042581943812962882375293348462523257081140457567348612069746943329842264291823570671268374580651696311114624358304235261945894627668267192756606441264485628097480920062857007640396910214970556623416565940789636657349735150043836194242061994234044262604284350296258397208287158735477739515615890093167555389262170576609082365199242352356197706754361085079177223144662701424848070607319078068303190442737202186364818021792860690571733432439513976759807778513151206801184300729685910765785586373831699595178352610150383283823456881293647763022411686252640648120690251120902631370825525354213297549430441989419362406888242180413640397005462289002837178086683143441254722528075315187910994986929463063282350677644105312484770818851268755183086729904524488901102287310169865855725358976453628171038414004415469635124255044890245890050115901243603489384920067923087045070616429510114587493955384903357111302068595548921504222171096098548413208088831560744996899783844118318185694142620796984004522106434428513215881883542758888862576036415421097762413907290417004936441609238204617100586876487061497586106631983740139555573272626681186969272113315348553052708453716313010811194726904231406455432865684477036960953564406390115786323388585604716504384778912812410729908949581143722120318954849846535676912868526526501078193502393524062471534154104899815734648650035608611113327222040864146091286020205304970098510045582130989981665393076480660907742469107193219475618455618115516353495211289597815564506193368287178714208989206470099207227171770619580227427772058576958549342547850566371060314330889132466260972915500785842700966615103949831075688522846389635990078358138687466663099265099431775674237640711466272609872329090894406587154198409486434056948991642623725868520261081714501891452704954562834244485695899485150794033902595303371632597184940525684558272222395813587950566598836575728711404672894869851301199508345442816914540274231773573695049117433232750564343477296571911336451338765122801905492189124021699698020217831160061375249740348841211772476455089061870953510480256335713228323198782026742817220321247980121667780800877801219532811542139900480803615083739957513418528009253849655053312995534574307148952727627870318872325094411860749809155407484065987101730385346571248798467212335910821152286411077915790397497756477613051365987943518909759211252763081626026136209474490841118337332773116122063152414208776801671614382203998310801791046109980464795153775904284579208046765170299376571712696359391195309011046580945099118345329164807866461624513459858969478261348365746242842254100449074846018162381649508771205692387943049083877156128753239386498305599949138477358461424273464036997642435352074743094695564535693378173888280633866732018710701060752702258884562187458492514181027419045608607139753797741693225900923436163273291784047946102859573341135995351940672974945745062320931107916232460722010886651827074516009065280667168017782964663521168472263155891094369134584611694802620433621767214124173962636180142978128638945692419270222518432363382128100260544917455244318162619360808797214154001396840051520865249909119773623276044783996235484958441702533661095335337458603732924068113476544273220040621287278168707393471504842692312354782265568742305367773635557008065688109790648713350572351799924638273829816187626279342407486758617884199669669286080608957640162096427744397522103026413782698158732581790000716751490076906346484023835702438474105176931779065689980130347837155056303467742499515965713045957954225592059807462917282749105358673064716135765849677591608061323905019687616579401117839719269327243007586938365568212311638431283680946079388989080798521721770825311237382299640977231722390040018733060008726711369177955792504805871660952275133036361448257222162174106121886956846208577175900217031085260775753651365765038925717954695019720235653672968689019573262654460436772900765775615489257834882352941349073672575670561593061387879337673233294306479935031268311515186416299622966578517978675818927585118344348361158710756313053131716293124192982037977789379782122120656399498488608931743952536041546453299501041577456229618221253519224906611827751220393777623642577532653929191439603183004880021982807536023221789599010502125687724004685177438516674638976736887749480118357141229355178588718777866510629202733751110559334924038607709059709853979249569510212755627954315025008066453716096825677236680969921750877126730256949811077056975031686370565845816981036167892330455103497165407984322792515265566483796338273488042877728447328933645773410093062365682687268013318931065552717013674172822704288279197461978805944285413220284999303849740540429893025407810120053701999064303195562726870079068213843151094378846458471168159763363401468459072474435300433314015701363633705309153196187013664717617975618648227816754951474354742056233896619815305871556180590934191775446450232435064334173434855333465262160341517250209548644211312373841441024747539900101488865742679168673356769004244781832745045012713439497231232255815861738982590755401780194874615548229070120796893835181030047378827641086164272219294123942746140207443292075817414598536256892540490923602419336928186124051416665048479530882042184097629985897052425322145715174649893481917612568426372077919256931921063600255204010662044398922537796993713110889134889921360833579323314386803074533058134342770923839546994120322442157750203621967931319597649960815556196358566683782572730174920215034531104191490057838260392829741446722127017532444082857280503217574522928285094747407153894570747792487061998260753833304433675066923630595212677695003060727653119915126939127827754432456052655283764591328484359469704894122366077507922825301623961196207923544095047285011474898262448957681893278273601046641810135121516552187096005252171171905022763076761687166299014789581539855448453229411352775826042558462563147630238335355859149814380543807473386539264830261256996173935860136236427622918234260408201158550118527706241993700526213016072648406003487895118011337828945314863348154387066988573131543747121745028364818130265528614742576976975564213718421245904443000581698214695522541683926528961160986876871840844632069685227319014872180179370554032205521013345746425253133686231659075343389374580200717637698542920298315739628019867736462368334051114029380922339886663078026309916370486909128253195100898377068612057592121356555290537815049586626181680384845905180029133497372417653664436161971980137048236053329456957495141918670077299206755740534997886723627476115663811233372206043170460623060506091246306386543951687123557178508806912199010111871";
        String test2 = "1432219";
        String test3 = "42767854615790820292944831840714943359894187047948450037336809401264092298894490339723170235305129677267060933619172682578764724528024649451075131679109777263591648456729485464839877320061461069243974933498371934575012528555827338953724780861662784034839154178040563249817555067081448332223588411419168442553970020118370358794959779864819714402968003470365044797881527445340976945193818119467023653961507607672480115226579679195083984107550649620824228334531543881248523270728845883011347557806714125988595750797445903460187069102923827814511796767245574859856245433535202213866357865001893279481556044431076323101967578726169437167866864433985495890782177337227185218722003203201794524473658120818757906858018522776715639010350584179192618574032568118118609428514149350137179799798509363342933168141703795277960609902578193965353966732758522319326510476003141627976495471194647651191765940623801848650779996861991716801192868381714592671157213385358454372258678286185038661251898041199455484881497973936886129286780686747702354266676649133047345268803970772136574778724059680910889846701031833468068701979269662983956502485168033946609770137842651146059273082836506077338453677150197865590089199161058651336150874965473699606051616750107442277197178936688141691056518266386172813294511346655182323777419242146803539629808395049965699535272276902817614992917612927025979571436056418178949140225831714010026397581438647144388850448143782384993050908181782121784294922444218824177798052454616802442043385673094510700252387351590505241357656396376170570838637068429512330065547472613577751410152513915714166057883408992271281823592172333654887223386232551975763603851710020471730161184180640812534293795148973065648040320936081719321657015873251252438179935213522036777508405231559635933218588146968578575964379037900738820562221783370763718270548271942160879283346733139062721676158522361533668704462398258010274851756504022170692557968534354343300976925558662656552021225536052236166733671370810493478857779656160557033130699196730596823835866942383406014324343783777539237677792451989779191005800821612057527173069156047746886314264888886920021988864698336973375949221207087151293792642382667520852406157133901720414180577613687865572943934469907502558232579505371542207400025172278481715443291693401941467763248672444891029778464850850998910451866532251760265573729603802891979681199941199058262753251051247038814898450192160069049824567851341865948819288467203875175473770134200197684457826486518709881470102852093201457965720215213058487673191409542861896211110569915555788853974841074076366685605058887536260221712351483096796829688703805892797869297796003334770994443794789460259639436865437812910241961445382357524033812312224783435809748252815436505470248482168172542366777257733653560456219150752921112615226017071525633643673264241122463875175583077761780573333101393148223764295110530230833646717923630745738812086412736671406343368298252156032118474543057099651798412740139013104123480347608236951823601336247508674889789494483794628001425344165783788429049730291326775455015785327577865377064397566794918739831414079787693198248140637113125565595305998282580721676261634498566237966614318941397734268015425568890740425312778238252662876746954156253519077411732018085846119889733839268453412968907858943693089597738545774072868871022839381446938075550039536742864199000908389925554691777850180161524332130073243881970286384249150136987633055208076388268958344328919145620288311537387853748176907053434533948744876865239789707206727054699151876690589023127693784859005126867245144990541144502571475179281742590537105515917376706167473011218582298393879651200544930737095993892411425220115292455512046640587174478149165594377091626060310391405243838577142799370503965244703765138756627518023743947119802986986532252546116477951027231307131628103042104039629499919572735529345439335549727142664736202293026484344441050630567027253471369103560266482945879441209004770164675020115476783653466174012741661723993500655369697109626010269380076073933015864761704176611703072139146747597003865521022642104228419619843927108260238084570397138708740181474347163241522446780620603392403687603888076553679045954833871460870755109132271738691459746851320926797113625441143010401758187073392500078061166186149727409676020612731477477496862648324993156390312514509978182394005049176325656482925314334308846020046440000639094498194888324242274543355772503522914560552598223947118463742841515723677871749503874006924229568354106404788800337347740726960903805684221263837486950787248911647072244868181616958029769190594368044110679179639645980860201597430267777459655372871993352465518117174671133742384885531127239604520105123727230849911680326443684000340446147937873667767227624842441390296900995179520080641610292722850119464836580325090471323736225890294980142988595694394073053215895013346101834933981247547372697246437008031025334926870805534589643288626312674442549515696840972195844322623489776395993997725883102424374473386242230020052319139538725050694563793252575203302986006568926586341522483619750551265949811840701660706687971699572637332236706033725130460780147305930796689592739802762127602300331109088320407488753453562201443009583869340530260133192585867600117793558618622877626140608235883463446585052941889282771610713456594091731994663257672424562807919185250771570978748558016087655314386429181778154999037395977801201222536602668579318195917221851258101758083465833807764504478328133760033685582322103480724065531895932039917203779203156040553746346772387443929520551627122239575483559165994485703508677722865190370481258839816840706093115274279356732858077656941579688491810646089766375954256605013212947107680641700379830628558534532701353225658907237335822869646320919937486195881402477347072922997644748078880017641720321497893274887727279247817230724007001520405446788235407924339589275318658718824019308723325037628135839936194865389246778785484224136240513164802724185350906503263939998152201969404224284851353929162842159002494160461334274924788445418313020719064697643073211899597216839617241323956298475147631936745340993794786362122100021070985418754276295234662670333162104340353095385544657319880579379906274682249802800845859334842970692716308206359497045039047894058089399866389624780981978085896624346900360571598520216940381587071285958497155631482721452214648993874243450874956631856720123296440913509093669827146153180469767433504561046437484524515293979237377991209712765962632838588822180359961992788574139615251950913574644651207439995528858114472995911722528828790960400270676875166161939741700924096377882962772526118510149529098157733017933337496630319171190616687753486928733354625068986857196646261563989044574797981270617089057226390794666311751192327631540192548655459578506043592663616062769069836457346194068474176132510064511610117400341310411426000998578144122817400179584819131405912398612085587124626912794546013764785843274068027858995747888172680971572206968091015445337290861835783980747471461015521311208355915962202714480089884097249709377165451728632422251230084667248727648072440251993269156317610868685295846232492883010588697174635533597605834450249882921427658569868883414799635112078926523707047988262628826843234898036034699263633285219983947947102364186704490860419225940767023498819222899748637736136929299603365634669304329289193002180868079267831256753666692578016598885536576757243005565124272778934460000656133474422706312579704797332965888987321865639934115540341358438065159979966516649509059972742742859883148151328808103859578112480441464277834533174833896376621814776042440697291859846516369392086372254665861285937409320474020680208941413993134675771984152737919309617874095184511004441704637414657377204495521150940370391369816136133983987959653102357045282415379947968251076420098012505820501069271733453309150705588274173445852803861126110689326352001921046066346433959229953549279092972503658190837209557302503876248001129441633640343374507764567392795980560783306587466656895994346821030188171996741604459649768510697714192580042040101750692371398942842500442445462269343139517683266487839338542443169246460653530698650325346136357734184681042975047635944793223022235246268651870018710450581435529607254366048869493833744884331399960456341161524764264081615200455615465925723132075411240169896584999493701334792763601560521725937880035580427191600072833098777060365102978298741740559073275852763938780836609797603716875112885764040607658550533844408290490010802790842002942292935369291644839617793990910895308977723653062881593207714109720695034340437197019621968080117519794848132586742911614980669439330348142456126849768719198483462298008318935405664818315956667907954514033766806239587330742325680711653716183320470951491901907421070418246355033490024779722775524553362711286647617964163847164933401979458666304006708368763218332476561345205255639459643444256743045787508311558394991701816915267581835649555296896252897237006404723594796400109216516930136483261469100739753281302804818082275735965571356243205409672153514152830169411991633125429246600926046750109377245075186063774301024268884824103787866848063266853457600668442319180654169447895010411843408292686118099805402852556814966811008369348597110442872837094072059087232837205291461239853639994518924479438927379348327739109781565914159761167665584025124425923844801188360781762018699315163461229173330894272797116474430040071501881164984840886621509629770804885731934408262630754177569630312231904935609457496213783238786007928894185681679202644961896031520772120429456532334651866707926275039616875628244135012101648429121896413946679889877828086708457516884940565793756567939396973544976573326617620245079002790968407887831523704293463842790307287785628353910524550357149296905848302331279051221613790082068853444332742995671850649946821132877723913186786300652152247618157706125750578092402909964449626211673467131785274416643250628726377006207603592185";
        System.out.println(test3.length());

        System.out.println("Result is:" + s.removeKdigits(test2, 3));
    }
}
