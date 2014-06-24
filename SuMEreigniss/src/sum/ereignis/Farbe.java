/*    */ package sum.ereignis;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.io.Serializable;
/*    */ import javax.swing.JColorChooser;
/*    */ 
/*    */ public class Farbe
/*    */   implements Serializable
/*    */ {
/*    */   public static final int SCHWARZ = 0;
/*    */   public static final int BLAU = 1;
/*    */   public static final int CYAN = 2;
/*    */   public static final int DUNKELGRAU = 3;
/*    */   public static final int GRAU = 4;
/*    */   public static final int GRUEN = 5;
/*    */   public static final int HELLGRAU = 6;
/*    */   public static final int MAGENTA = 7;
/*    */   public static final int ORANGE = 8;
/*    */   public static final int PINK = 9;
/*    */   public static final int ROT = 10;
/*    */   public static final int WEISS = 11;
/*    */   public static final int GELB = 12;
/*    */ 
/*    */   public static final Color rgb(int pR, int pG, int pB)
/*    */   {
/* 37 */     return new Color(pR, pG, pB);
/*    */   }
/*    */ 
/*    */   public static final Color neueFarbe(Color pAlteFarbe)
/*    */   {
/* 47 */     Color neueFarbe = JColorChooser.showDialog(Ereignisanwendung.hatSuMPrivateAnwendung.bildschirm(), "Farbauswahl", pAlteFarbe);
/* 48 */     if (neueFarbe != null) {
/* 49 */       return neueFarbe;
/*    */     }
/* 51 */     return pAlteFarbe;
/*    */   }
/*    */ }

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMEreignis.jar
 * Qualified Name:     sum.ereignis.Farbe
 * JD-Core Version:    0.6.0
 */