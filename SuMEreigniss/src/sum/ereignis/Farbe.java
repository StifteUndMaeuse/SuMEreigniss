 package sum.ereignis;
 
 import java.awt.Color;
 import java.io.Serializable;
 import javax.swing.JColorChooser;
 
 public class Farbe
   implements Serializable
 {
   public static final int SCHWARZ = 0;
   public static final int BLAU = 1;
   public static final int CYAN = 2;
   public static final int DUNKELGRAU = 3;
   public static final int GRAU = 4;
   public static final int GRUEN = 5;
   public static final int HELLGRAU = 6;
   public static final int MAGENTA = 7;
   public static final int ORANGE = 8;
   public static final int PINK = 9;
   public static final int ROT = 10;
   public static final int WEISS = 11;
   public static final int GELB = 12;
 
   public static final Color rgb(int pR, int pG, int pB)
   {
     return new Color(pR, pG, pB);
   }
 
   public static final Color neueFarbe(Color pAlteFarbe)
   {
     Color neueFarbe = JColorChooser.showDialog(Ereignisanwendung.hatSuMPrivateAnwendung.bildschirm(), "Farbauswahl", pAlteFarbe);
     if (neueFarbe != null) {
       return neueFarbe;
     }
     return pAlteFarbe;
   }
 }

