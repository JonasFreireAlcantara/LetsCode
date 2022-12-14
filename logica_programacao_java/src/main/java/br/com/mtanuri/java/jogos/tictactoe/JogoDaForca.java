package br.com.mtanuri.java.jogos.tictactoe;

import java.util.concurrent.ThreadLocalRandom;

public class JogoDaForca {

    private static String[] palavras = { "Abelha",
            "Ácaro da Sarna",
            "Águia chilena",
            "Águia cinzenta",
            "Águia dourada",
            "Albatroz",
            "Alce",
            "Anta",
            "Antrax",
            "Aranha caranguejeira",
            "Aranha marrom",
            "Araponga",
            "Arara vermelha",
            "Aratu",
            "Asno",
            "Avestruz",
            "Bacilo do tifo",
            "Baleia azul",
            "Barata",
            "Beija-flor",
            "Bem-te-vi",
            "Bicho-da-seda",
            "Bicho-preguiça",
            "Borboleta",
            "Búfalo",
            "Bugio preto",
            "Cabra",
            "Cágado",
            "Calango",
            "Camaleão",
            "Camelo",
            "Cão",
            "Capivara",
            "Caranguejo uça",
            "Cardeal",
            "Carneiro",
            "Carpa",
            "Carrapato",
            "Cascavel",
            "Castor",
            "Cavalo",
            "Chacal",
            "Chimpanzé",
            "Chupim",
            "Cigarra",
            "Cisne",
            "Civeta",
            "Coala",
            "Cobaia",
            "Cobra-cega",
            "Coelho",
            "Condor",
            "Corvina",
            "Corvo",
            "Crocodilo",
            "Curimbatá",
            "Dourado",
            "Dragão de comodo",
            "Elefante",
            "Ema",
            "Esquilo",
            "Foca",
            "Gafanhoto",
            "Galinha d'Angola",
            "Galinha",
            "Gambá",
            "Ganso",
            "Garoupa",
            "Gato",
            "Gato-do-mato",
            "Gavião",
            "Gavião-quiriquiqui",
            "Girafa",
            "Golfinho",
            "Gorila",
            "Gralha",
            "Guará",
            "Hamster",
            "Hipopótamo",
            "Homem",
            "Jaburu",
            "Jabuti",
            "Jacaré",
            "Jacutinga",
            "Jaguatirica",
            "Jararaca",
            "João-de-Barro",
            "Jobóia",
            "Lagartixa",
            "Lagarto",
            "Lambari",
            "Leão",
            "Lebre",
            "Leopardo",
            "Lhama",
            "Libellula",
            "Lince",
            "Lobo",
            "Lombriga",
            "Lontra",
            "Lula",
            "Mão-pelada",
            "Marreco",
            "Mico-amarelo",
            "Mico-leão",
            "Mico-preto",
            "Mico-ruivo",
            "Mosquito da Dengue",
            "Namorado",
            "Onça",
            "Orangotango",
            "Ostra japonesa",
            "Ostra",
            "Paca",
            "Pacu",
            "Panda Gigante",
            "Papagaio",
            "Pato",
            "Pavão",
            "Peixe-espada",
            "Peru",
            "Pica-pau",
            "Pinguim",
            "Pintado",
            "Piolho",
            "Piranha",
            "Pirarucu",
            "Polvo",
            "Pombo",
            "Porco",
            "Porco-do-mato",
            "Protozoário",
            "Pulga",
            "Pulgão",
            "Puma",
            "Quero-quero",
            "Rã",
            "Raposa",
            "Rato",
            "Rinoceronte",
            "Robalo",
            "Sabiá",
            "Sagui",
            "Salmão",
            "Sapo cururu",
            "Sapo",
            "Saracura",
            "Saracura",
            "Sardinha",
            "Saúva",
            "Tamanduá",
            "Tatu",
            "Tico-tico",
            "Tigre",
            "Touro, vaca",
            "Traira",
            "Tucano",
            "Tucunaré",
            "Uirapuru",
            "Urso",
            "Urubu",
            "Urutu",
            "Veado",
            "Vespa",
            "Xexéu",
            "Zebra",
            "Zorrilho" };

    private static String palavraASerDescoberta;

    private static char[] letrasJaDecifradas;

    public static String sorteioDePalavra() {
        int numeroRandomico = ThreadLocalRandom.current().nextInt(palavras.length);
        return palavras[numeroRandomico];
    }

    private static String imprimirEspacosDeLetras() {
        return "__ __ __ __ __";
    }

    private static char[] constroiArrayDeLetrasASeremDecifradas() {
        char[] charArray = palavraASerDescoberta.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != ' ' && charArray[i] != '-') {
                charArray[i]='_';
            }
        }
        return charArray;
    }

    public static void main(String[] args) {
        palavraASerDescoberta = sorteioDePalavra();
        char[] letrasASeremDecifradas = constroiArrayDeLetrasASeremDecifradas();
        System.out.println(letrasASeremDecifradas);
    }
}
