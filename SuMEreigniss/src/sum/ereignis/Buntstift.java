/*     */ package sum.ereignis;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.geom.Ellipse2D.Double;
/*     */ import java.awt.geom.Line2D.Double;
/*     */ import java.awt.geom.Rectangle2D.Double;
/*     */ 
/*     */ public class Buntstift extends Stift
/*     */ {
/*  23 */   private String zAktuellFont = "Helvetica";
/*  24 */   private int zSchriftStil = 0;
/*  25 */   private int zSchriftGroesse = 12;
/*  26 */   private Font zSchriftArt = Schrift.STANDARDSCHRIFT;
/*  27 */   private Color zFarbe = Color.black;
/*  28 */   private int zLinienbreite = 1;
/*  29 */   private int zMuster = 0;
/*     */ 
/*     */   public Buntstift()
/*     */   {
/*     */   }
/*     */ 
/*     */   public Buntstift(Fenster pFenster)
/*     */   {
/*  46 */     super(pFenster);
/*     */   }
/*     */ 
/*     */   public void setzeFarbe(Color pFarbe)
/*     */   {
/*  55 */     this.zFarbe = pFarbe;
/*     */   }
/*     */ 
/*     */   public void setzeFarbe(int pFarbe)
/*     */   {
/*  64 */     if (pFarbe < 0)
/*  65 */       pFarbe = 0;
/*  66 */     pFarbe %= 13;
/*  67 */     switch (pFarbe)
/*     */     {
/*     */     case 0:
/*  70 */       setzeFarbe(Color.black);
/*  71 */       break;
/*     */     case 1:
/*  73 */       setzeFarbe(Color.blue);
/*  74 */       break;
/*     */     case 2:
/*  76 */       setzeFarbe(Color.cyan);
/*  77 */       break;
/*     */     case 3:
/*  79 */       setzeFarbe(Color.darkGray);
/*  80 */       break;
/*     */     case 4:
/*  82 */       setzeFarbe(Color.gray);
/*  83 */       break;
/*     */     case 5:
/*  85 */       setzeFarbe(Color.green);
/*  86 */       break;
/*     */     case 6:
/*  88 */       setzeFarbe(Color.lightGray);
/*  89 */       break;
/*     */     case 7:
/*  91 */       setzeFarbe(Color.magenta);
/*  92 */       break;
/*     */     case 8:
/*  94 */       setzeFarbe(Color.orange);
/*  95 */       break;
/*     */     case 9:
/*  97 */       setzeFarbe(Color.pink);
/*  98 */       break;
/*     */     case 10:
/* 100 */       setzeFarbe(Color.red);
/* 101 */       break;
/*     */     case 11:
/* 103 */       setzeFarbe(Color.white);
/* 104 */       break;
/*     */     case 12:
/* 106 */       setzeFarbe(Color.yellow);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setzeLinienbreite(int pBreite)
/*     */   {
/* 118 */     if (pBreite > 0)
/*     */     {
/* 120 */       this.zLinienbreite = pBreite;
/* 121 */       this.hatStroke = new BasicStroke(pBreite * 1.0F, 0, 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setzeLinienBreite(int pBreite)
/*     */   {
/* 133 */     setzeLinienbreite(pBreite);
/*     */   }
/*     */ 
/*     */   public int linienbreite()
/*     */   {
/* 143 */     return this.zLinienbreite;
/*     */   }
/*     */ 
/*     */   public int linienBreite()
/*     */   {
/* 153 */     return this.zLinienbreite;
/*     */   }
/*     */ 
/*     */   public void setzeSchriftart(String pArt)
/*     */   {
/* 163 */     this.zAktuellFont = pArt;
/*     */   }
/*     */ 
/*     */   public void setzeSchriftArt(String pArt)
/*     */   {
/* 173 */     this.zAktuellFont = pArt;
/*     */   }
/*     */ 
/*     */   public void setzeSchriftgroesse(int pGroesse)
/*     */   {
/* 183 */     this.zSchriftGroesse = pGroesse;
/*     */   }
/*     */ 
/*     */   public void setzeSchriftGroesse(int pGroesse)
/*     */   {
/* 193 */     this.zSchriftGroesse = pGroesse;
/*     */   }
/*     */ 
/*     */   public void setzeSchriftstil(int pStil)
/*     */   {
/* 203 */     this.zSchriftStil = pStil;
/*     */   }
/*     */ 
/*     */   public void setzeSchriftStil(int pStil)
/*     */   {
/* 213 */     this.zSchriftStil = pStil;
/*     */   }
/*     */ 
/*     */   public void setzeFuellmuster(int pMuster)
/*     */   {
/* 223 */     this.zMuster = pMuster;
/*     */   }
/*     */ 
/*     */   public void setzeFuellMuster(int pMuster)
/*     */   {
/* 233 */     this.zMuster = pMuster;
/*     */   }
/*     */ 
/*     */   public void zeichneRechteck(double pBreite, double pHoehe)
/*     */   {
/* 249 */     Graphics2D g = get2DGraphics(this.kenntPrivatschirm.g());
/* 250 */     if (g != null)
/*     */     {
/* 252 */       setzeZustand(g);
/* 253 */       if (this.zMuster == 0) {
/* 254 */         g.draw(new Rectangle2D.Double(this.zStiftH, this.zStiftV, pBreite, pHoehe));
/*     */       }
/*     */       else
/*     */       {
/* 258 */         g.fill(new Rectangle2D.Double(this.zStiftH, this.zStiftV, pBreite, pHoehe));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void zeichneKreis(double pRadius)
/*     */   {
/* 275 */     Graphics2D g = get2DGraphics(this.kenntPrivatschirm.g());
/* 276 */     if (g != null)
/*     */     {
/* 278 */       setzeZustand(g);
/* 279 */       if (this.zMuster == 0) {
/* 280 */         g.draw(new Ellipse2D.Double(this.zStiftH - pRadius, this.zStiftV - pRadius, 2.0D * pRadius, 2.0D * pRadius));
/*     */       }
/*     */       else
/* 283 */         g.fill(new Ellipse2D.Double(this.zStiftH - pRadius, this.zStiftV - pRadius, 2.0D * pRadius, 2.0D * pRadius));
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void zeichneLinie(double x1, double y1, double x2, double y2)
/*     */   {
/* 295 */     Graphics2D g = get2DGraphics(this.kenntPrivatschirm.g());
/* 296 */     if (g != null)
/*     */     {
/* 298 */       setzeZustand(g);
/* 299 */       g.draw(new Line2D.Double(x1, y1, x2, y2));
/*     */     }
/*     */   }
/*     */ 
/*     */   public int textbreite(String pText)
/*     */   {
/* 313 */     Graphics2D g = get2DGraphics(this.kenntPrivatschirm.g());
/* 314 */     if (g != null)
/*     */     {
/* 316 */       setzeZustand(g);
/* 317 */       return g.getFontMetrics().stringWidth(pText);
/*     */     }
/*     */ 
/* 320 */     return 12;
/*     */   }
/*     */ 
/*     */   public int zeichenbreite(char pZeichen)
/*     */   {
/* 331 */     String lText = "" + pZeichen;
/* 332 */     return textbreite(lText);
/*     */   }
/*     */ 
/*     */   public int zahlbreite(int pZahl)
/*     */   {
/* 343 */     String lText = "" + pZahl;
/* 344 */     return textbreite(lText);
/*     */   }
/*     */ 
/*     */   public int zahlbreite(double pZahl)
/*     */   {
/* 355 */     String lText = "" + pZahl;
/* 356 */     return textbreite(lText);
/*     */   }
/*     */ 
/*     */   public int textBreite(String pText)
/*     */   {
/* 366 */     return textbreite(pText);
/*     */   }
/*     */ 
/*     */   public int zeichenBreite(char pZeichen)
/*     */   {
/* 376 */     return zeichenbreite(pZeichen);
/*     */   }
/*     */ 
/*     */   public int zahlBreite(int pZahl)
/*     */   {
/* 386 */     return zahlbreite(pZahl);
/*     */   }
/*     */ 
/*     */   public int zahlBreite(double pZahl)
/*     */   {
/* 396 */     return zahlbreite(pZahl);
/*     */   }
/*     */ 
/*     */   protected void setzeZustand(Graphics2D g)
/*     */   {
/* 404 */     if ((this.zMuster == 2) && (this.zFarbe.getTransparency() != 3))
/*     */     {
/* 406 */       this.zFarbe = new Color(this.zFarbe.getRed(), this.zFarbe.getGreen(), this.zFarbe.getBlue(), 128);
/*     */     }
/* 409 */     else if ((this.zMuster != 2) && (this.zFarbe.getTransparency() != 1))
/*     */     {
/* 411 */       this.zFarbe = new Color(this.zFarbe.getRed(), this.zFarbe.getGreen(), this.zFarbe.getBlue());
/*     */     }
/* 413 */     if (this.zSchreibModus == 1)
/*     */     {
/* 415 */       g.setPaint(this.kenntPrivatschirm.hintergrundfarbe());
/* 416 */       g.setPaintMode();
/*     */     }
/* 419 */     else if (this.zSchreibModus == 0)
/*     */     {
/* 421 */       g.setPaint(this.zFarbe);
/* 422 */       g.setPaintMode();
/*     */     }
/*     */     else
/*     */     {
/* 426 */       g.setPaint(this.zFarbe);
/* 427 */       g.setXORMode(this.kenntPrivatschirm.hintergrundfarbe());
/*     */     }
/* 429 */     this.zSchriftArt = new Font(this.zAktuellFont, this.zSchriftStil, this.zSchriftGroesse);
/* 430 */     g.setFont(this.zSchriftArt);
/*     */   }
/*     */ 
/*     */   protected void setzeStandard()
/*     */   {
/* 438 */     this.zStiftH = 0.0D;
/* 439 */     this.zStiftV = 0.0D;
/* 440 */     this.zHoch = true;
/* 441 */     this.zWinkel = 0.0D;
/* 442 */     this.zSchreibModus = 0;
/* 443 */     this.zAktuellFont = "Helvetica";
/* 444 */     this.zSchriftStil = 0;
/* 445 */     this.zSchriftGroesse = 12;
/* 446 */     this.zSchriftArt = Schrift.STANDARDSCHRIFT;
/* 447 */     this.zFarbe = Color.black;
/* 448 */     this.zLinienbreite = 1;
/* 449 */     this.zMuster = 0;
/*     */   }
/*     */ }

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMEreignis.jar
 * Qualified Name:     sum.ereignis.Buntstift
 * JD-Core Version:    0.6.0
 */