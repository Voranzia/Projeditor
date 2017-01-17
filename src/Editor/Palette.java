package Editor;

public class Palette {
    static int couleur;
    static int colorPicker(int coul){
        if (coul==0){
            return couleur = ImageUtil.computePixel(255, 0, 0, 255);
        }else if (coul==1){//bleu
            return couleur = ImageUtil.computePixel( 255, 255, 0, 0);
        }else if(coul==2){//rouge
            return couleur = ImageUtil.computePixel( 255, 0, 255, 0);
        }else if(coul==3){//vert
            return couleur = ImageUtil.computePixel( 255, 0, 255, 0);
        }else if(coul==4){//jaune
            return couleur = ImageUtil.computePixel( 255, 255, 255, 0);
        }else if(coul==5){//violet
            return couleur = ImageUtil.computePixel( 255, 102, 0, 153);
        }else if(coul==6){//rose
            return couleur = ImageUtil.computePixel( 255, 253, 108, 158);
        }else if(coul==7){//orange
            return couleur = ImageUtil.computePixel( 255, 237, 127, 16);
        }else if(coul==8){//marron
            return couleur = ImageUtil.computePixel( 255, 88, 41, 0);
        }else if(coul==9){//gris
            return couleur = ImageUtil.computePixel( 255, 96, 96, 96);
        }else if(coul==10){//noir
            return couleur = ImageUtil.computePixel( 255, 0, 0, 0);
        }else if(coul==11){//blanc
            return couleur = ImageUtil.computePixel( 255, 255, 255, 255);
        }
        return couleur;
    }
}