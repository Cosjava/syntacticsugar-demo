public class RecordPattern {

    private record Nourriture(String type, float quantite) {
    }

    private record Oiseau(String nom, String couleur, Nourriture food) {
        public void chanter() {
            System.out.println("Cuicuicui");
        }
    }

    private record Chien(String nom, int poids) {
        public void aboyer() {
            System.out.println("Ouaouaouf");
        }

    }

    private static String getInfos(Record record) {
        if (record instanceof Oiseau(String nomOiseau,String couleurOiseau,Nourriture(String t,float q) food) monOiseau) {
            return String.format("""
                    L'oiseau est de type : %s et a pour couleur : %s et se nourrit de %s (%s kilos) [%s %s]""", nomOiseau, couleurOiseau, t, q, monOiseau, food);
        } else if (record instanceof Chien(String nomChien,int poids) monChien) {
            return String.format("""
                    Le chien est de type : %s et il pèse : %s kg (%s)""", nomChien, poids, monChien);
        } else {
            return "Type inconnu";
        }
    }

    private static String getInfosSwitch(Record record) {
        return switch (record) {
            case Oiseau(String nomOiseau,String couleurOiseau,Nourriture(String t,float q) food) monOiseau ->
                    String.format("""
                            L'oiseau est de type : %s et a pour couleur : %s et se nourrit de %s (%s kilos) [%s %s]""", nomOiseau, couleurOiseau, t, q, monOiseau, food);
            case Chien(String nomChien,int poids) monChien when poids > 10 -> String.format("""
                    ATTENTION GROS CHIEN : Le chien est de type : %s et il pèse : %s kg (%s)""", nomChien, poids, monChien);
            case Chien(String nomChien,int poids) monChien -> String.format("""
                    Le chien est de type : %s et il pèse : %s kg (%s)""", nomChien, poids, monChien);
            case null -> "Attention problème !";
            default -> "Type inconnu";
        };
    }

    public static void main(String... args) {
        var oiseau = new Oiseau("Mésange charbonnière", "Jaune et noire", new Nourriture("Graines", 0.2f));
        var chien = new Chien("Caniche", 6);
        var grosChien = new Chien("Labrador", 11);
        System.out.println(getInfos(oiseau));
        System.out.println(getInfos(chien));

        /**      System.out.println(getInfosSwitch(oiseau));
         System.out.println(getInfosSwitch(chien));
         System.out.println(getInfosSwitch(grosChien));**/
        //     System.out.println(getInfosSwitch(null));

    }


}
