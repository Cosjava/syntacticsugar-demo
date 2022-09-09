public class RecordPattern {

    private record Oiseau(String nom, String couleur) {
        public void chanter() {
            System.out.println("Cuicuicui");
        }
    }

    private record Chien(String nom, String taille) {
        public void aboyer() {
            System.out.println("Ouaf Ouf");
        }
    }

    private static String getInfos(Record record) {
        if (record instanceof Oiseau(String nomOiseau,String couleurOiseau) monOiseau) {
            return "L'oiseau est de type : " + nomOiseau + " et a pour couleur : " + couleurOiseau + " (" + monOiseau.toString() + ")";
        } else if (record instanceof Chien(String nomChien,String tailleChien) monChier) {
            return "Le chien est de type : " + nomChien + " et il est de taille : " + tailleChien + " (" + monChier.toString() + ")";
        } else {
            return "Type inconnu";
        }
    }

    private static String getInfosSwitch(Record record) {
        return switch (record) {
            case Oiseau(String nomOiseau,String couleurOiseau) monOiseau ->
                    "L'oiseau est de type : " + nomOiseau + " et a pour couleur : " + couleurOiseau + " (" + monOiseau.toString() + ")";
            case Chien(String nomChien,String tailleChien) monChien ->
                    "Le chien est de type : " + nomChien + " et il est de taille : " + tailleChien + " (" + monChien.toString() + ")";
            default -> "Type inconnu";
        };
    }

    public static void main(String... args) {
        var oiseau = new Oiseau("Mésange charbonnière", "Jaune et noire");
        var chien = new Chien("Labrador", "Moyenne");
        System.out.println(getInfos(oiseau));
        System.out.println(getInfos(chien));
        System.out.println(getInfosSwitch(oiseau));
        System.out.println(getInfosSwitch(chien));

    }


}
