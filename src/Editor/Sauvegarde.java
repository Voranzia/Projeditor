package Editor;

class Sauvegarde {
    static int[] savTab;
    static void creationEtat(int[] tab){
        savTab = tab;
    }
    static int[] chargerEtat(int[] savTab){
        return savTab;
    }
}
