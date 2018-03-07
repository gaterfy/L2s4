#define TAILLE_DICO 910
#define taille_mot 4

/* Un dictionnaire de mots de quatre lettres */
char *dico[] = { "drap", "nuee", "agit", "mais", "krak", "eric", 
     "sncf", "agir", "drop", "dome", "buis", "puce", "roda", "drue",
     "buse", "bure", "rode", "haie", "hais", "hait", "puer", "hall", "role",
     "halo", "haro", "puis", "hase", "decu", "pull", "vais", "puma", "haut",
     "valu", "vain", "vase", "alea", "vamp", "thon", "vaux", "vaut", "afin",
     "fier", "fief", "mica", "fiel", "thym", "fini", "midi", "epie", "meat",
     "mien", "fisc", "miel", "film", "mike", "feru", "tige", "mise", "epia",
     "tele", "fevr", "tien", "miss", "mile", "tint", "aout", "fetu", "tilt",
     "mita", "tenu", "mite", "agio", "ogre","crac", "omer",
     "fela", "fele", "meme", "pres", "pref", "tete", "pret", "tetu",
     "hele", "here", "foin", "mode", "font", "foot", "moka", "fond",
     "fora", "fort", "toge", "todd", "mont", "mord", "mors", "fore", "mort",
     "four", "toit", "tond", "moto", "tors", "tort", "moue", "moud", 
     "yvan", "tome", "tord", "mous", "yves", "tous", "toux", "flan", "tour",
     "tout", "oeil", "veau", "utah", "flou", "flot", "heur", "vend",
     "venu", "vent", "velu", "oeuf", "vers", "vert", "flux", "veto", "veuf",
     "veut", "veux", "hale", "etal", "etai", "etat", "etau", "hata",
     "hate", "have", "buee", "jusa", "hair", "etui", "aire",
     "frac", "frai", "fret", "trie", "cade", "tram", "fris", "frit", "froc",
     "cage", "cadi", "trac", "duel", "jade", "cake", "tria", "cane", "dune",
     "camp", "trio", "dura", "cafe", "troc", "mole", "came", "trot", "jais",
     "rude", "trop", "trou", "aine", "ruer", "janv", "tole", "jars",
     "jasa", "dure", "truc", "java", "jazz", "jase", "rush", "tsar", "epee",
     "clot", "aile", "aigu", "aide", "hier", "vice",
     "vecu", "aera", "hela", "vint", "viol", "aise", "visa", 
     "aere", "hetu", "vive", "vite", "velo", "ange", "once", "vise", "anis",
     "anon", "onde", "anse", "ansi", "anus", "onze", "cene", "vetu", "onyx",
     "cepe", "hors", "home", "ceci", "houx", "vois", "voir", "voit", "voeu",
     "voix", "cout", "houe", "voie", "volt", "vont", "jean", "coit", "cens",
     "alfa", "cent", "allo", "vote", "vous", "cerf", "cern", "aloi", "jerk",
     "ceux", "jeun", "alto", "vlsi", "amas", "amen", "amer", "ames", "omet",
     "omis", "omit", "arcs", "caid", "oral", "orge", "vrac", "vrai", "fuel",
     "ardu", "ardt", "fuit", "chas", "char", "orme", "aria", "chef", "hote",
     "laid", "sage", "lait", "land", "muni", "tuer", "mule", "lama", "lard",
     "ores", "laps", "turc", "turf", "fuir", "chai", "chah", "sapa",
     "chat", "mure", "muer", "muet", "full", "sake", "cher", "chez", "saga",
     "saur", "oser", "chic", "tuez", "lame", "choc", "chou", "mura", "musc",
     "muse", "sain", "sais", "sait", "sana", "sang", "sans", "sali", "apex",
     "fute", "sari", "chut", "sauf", "saut", "sape", "osez", "saxo",
     "jill", "ciel", "cinq", "cime", "opus", "apre", "apte", "opta",
     "opte", "aval", "cola", "john", "jonc", "joli", "coco",
     "tres", "coke", "coin", "conf", "seau", "colt", "coma", "avec",
     "aveu", "avez", "corp", "joie", "cosy", "clip", "avis", "seme", "lest",
     "sein", "coud", "coup", "cour", "sens", "sent", "self", "sera", "serf",
     "seve", "sers", "sert", "joug", "typo", "jour",
     "auto", "ubac", "ovni", "owen", "legs", "clam", "clan", "clef", "aube",
     "lent", "clin", "soul", "clos", "clou", "sema", "leur", "sept", "club",
     "seul", "type", "sexe", "sexy", "skie", "ucla", "crue", "atre", "gain",
     "huit", "gang", "hune", "gala", "gale", "naja", "html", "cote", "nain",
     "cran", "shah", "laic", "cric", "crin", "cris", "croc", "auge",
     "skia", "cone", "audy", "aune", "huer", "crut", "aura", "gant",
     "oued", "lice", "gars", "nais", "lift", "lien", "ours", "nasa",
     "lion", "sied", "nazi", "lira", "lire", "zebu", "lise", "lisp", "show",
     "zele", "lesa", "zinc", "zero", "azur", "lied", "lier", "lieu", "lino",
     "sien", "snob", "silo", "sire", "site", "lese", "oree", "sofa",
     "loin", "loir", "long", "lors", "soif", "axer", "soir", "ieee", "ayez",
     "sole", "soli", "sors", "loup", "zona", "zone", "zoom", "gout",
     "noel", "souk", "soya", "mans", "gere", "soda", "soja", "neuf", "soin",
     "soit", "sono", "sont", "ibid", "ibis", "geai", "solo", "slip",
     "loto", "sort", "slow", "gens", "nerf", "nait", "naif", "ouie",
     "ouir", "cube", "erra", "bail", "bain", "cuir", "gata", "judo",
     "pack", "jube", "gate", "page", "juin", "pane", "quel", "jury", "jupe",
     "paon", "pars", "paru", "baba", "cuba", "paul", "gite", "watt",
     "apic", "cuis", "cuit", "banc", "bang", "jude", "quai",
     "cure", "basa", "base", "juif", "erre", "cuti", "baud", "baux", "pain",
     "pair", "paix", "quoi", "jute", "parc", "pari", "part",
     "papa", "pape", "neon", "pays", "esse", "spie", "spot", "neve",
     "gena", "nier", "girl", "unir", "unit", "unix", "gera", "noce", "gond",
     "hifi", "pere", "noir", "noix", "gnon", "nord", "gene", "nous",
     "peau", "idem", "ides", "pend", "goal", "perd", "perl", "pers",
     "peur", "peut", "ebat", "gong", "golf", "pese", "beau", 
     "glas", "pale", "pama", "pame", "ilot", "pesa", "stem", "echo",
     "echu", "pate", "ecot", "swap", "ecru", "gras", "bale", "stuc", "grog",
     "gros", "bati", "daim", "luge", "atil", "race", "dame", "urne",
     "etes", "luit", "suez", "luxe", "kart", "etre", "star", "raid",
     "suce", "suif", "rail", "suis", "suit", "suiv", "rang", "luth", "rare",
     "surf", "phil", "stop", "yard", "grec", "greg", "user", "gril", "gris",
     "beat", "dada", "dais", "lune", "grue", "kaki", "pied", "dard", "pieu",
     "daze", "urge", "yack", "suer", "lump", "suie", "rama",
     "rame", "rami", "rapt", "luxa", "rave", "rata", "rate", "indu",
     "usez", "bien", "pneu", "beer", "bebe", "bile", "bise", "pige", "exil",
     "pion", "egal", "pire", "pipe", "inca", "pise", "idee", "inne",
     "ions", "pois", "poix", "inox", "pool", "poli", "dela", "insu", "port",
     "beta", "bete", "pope", "edam", "pene", "pouf", "pour", "poux", "bock",
     "edit", "kent", "rein", "bois", "boit", "bond", "boni", "plan", 
     "boom", "bord", "iode", "bouc", "boue", "boul", "bous", "bout", "poil",
     "pond", "pont", "boxa", "boxe", "polo", "iota", "porc", "pore", "yeux",
     "plut", "dent", "demi", "bleu", "blet", "rene", "lynx", "bloc", "lyre",
     "lyse", "deux", "rala", "rend", "plat", "plot",
     "suca", "bref", "irai", "imbu", "rale", "irez", "iris", "fame", 
     "guet", "pris", "prit", "prix", "imsl", "tact", "nuit", "malt", "mare",
     "mari", "taie", "tain", "bras", "tank", "taon", "talc", "ntsc", "maux",
     "bric", "brie", "item", "brio", "brin", "bris", "broc", "brou", "taux",
     "face", "fade", "irmx", "mach", "brun", "brut", "rhum",
     "deja", "faim", "mage", "fais", "fait", "fana", "fane", "faon",
     "uucp", "pole", "fard", "fart", "mail", "main", "dine", "khan", "marc",
     "mark", "mars", "isba", "faut", "dina", "faux", "tais", "tait",
     "tant", "dery", "rien", "dime", "riez", "kilt", "math", "ture", "tard",
     "reel", "tapi", "ring", "maya", "rira", "rire", "tare", "taxi", "issu",
     "dick", "rite", "defi", "dieu", "deni", "dira", "dire", "dise", "rime",
     "king", "kilo", "dito", "reer", "kiwi", "rima", "kepi", "uree",
     "dois", "donc", "rock", "rixe", "dors", "dose", "kola", "dota", 
     "rond", "roll", "gres", "ivre", "dock", "fend", "roux",
     "teck", "dodu", "mens", "ment", "deca", "doit", "abat", "feue", "dont",
     "recu", "tend", "feve", "dort", "dosa", "abbe", "meus", "meut",
     "test", "doux", "yoga", "abri", "dote", "doue", "abus",
     "elan", "roue", "mout", "fera", "rose", "ocre", "menu", "elit",
     "elis", "elle", "obus", "mess", "male", "elue", "elut", "acre", 
     "acte", "emet", "emit", "emir", "emis", "emoi", "oter", "emue",
     "emut" }; 
 