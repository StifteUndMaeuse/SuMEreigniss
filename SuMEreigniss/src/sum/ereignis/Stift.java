/*     */ package sum.ereignis;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.geom.Ellipse2D.Double;
/*     */ import java.awt.geom.Line2D.Double;
/*     */ import java.awt.geom.Rectangle2D.Double;
/*     */ 
/*     */ public class Stift
/*     */ {
/*     */   protected BasicStroke hatStroke;
/*     */   protected Bildschirm kenntPrivatschirm;
/*     */   protected static final int NORMALMODUS = 0;
/*     */   protected static final int RADIERMODUS = 1;
/*     */   protected static final int WECHSELMODUS = 2;
/*  37 */   protected double zStiftH = 0.0D; protected double zStiftV = 0.0D;
/*  38 */   protected boolean zHoch = true;
/*  39 */   protected double zWinkel = 0.0D;
/*  40 */   protected int zSchreibModus = 0;
/*     */ 
/*     */   public Stift()
/*     */   {
/*  50 */     this.kenntPrivatschirm = Bildschirm.topFenster;
/*  51 */     this.hatStroke = new BasicStroke(1.0F, 0, 0);
/*     */ 
/*  53 */     setzeStandard();
/*     */   }
/*     */ 
/*     */   public Stift(Fenster pFenster)
/*     */   {
/*  64 */     this.kenntPrivatschirm = pFenster;
/*  65 */     this.hatStroke = new BasicStroke(1.0F, 0, 0);
/*     */ 
/*  67 */     setzeStandard();
/*     */   }
/*     */ 
/*     */   public void bewegeBis(double pH, double pV)
/*     */   {
/*  76 */     if (!this.zHoch)
/*  77 */       zeichneLinie(pH, pV, this.zStiftH, this.zStiftV);
/*  78 */     this.zStiftH = pH;
/*  79 */     this.zStiftV = pV;
/*     */   }
/*     */ 
/*     */   public void bewegeUm(double pDistanz)
/*     */   {
/*  91 */     double w = this.zWinkel * 3.141592653589793D / 180.0D;
/*  92 */     double x = this.zStiftH + pDistanz * Math.cos(w);
/*  93 */     double y = this.zStiftV - pDistanz * Math.sin(w);
/*  94 */     if (!this.zHoch)
/*  95 */       zeichneLinie(this.zStiftH, this.zStiftV, x, y);
/*  96 */     this.zStiftH = x;
/*  97 */     this.zStiftV = y;
/*     */   }
/*     */ 
/*     */   public void dreheBis(double pWinkel)
/*     */   {
/* 106 */     this.zWinkel = pWinkel;
/* 107 */     while (this.zWinkel < 0.0D)
/* 108 */       this.zWinkel += 360.0D;
/* 109 */     while (this.zWinkel >= 720.0D)
/* 110 */       this.zWinkel -= 360.0D;
/*     */   }
/*     */ 
/*     */   public void dreheZu(double pWohinH, double pWohinV)
/*     */   {
/* 120 */     if ((pWohinH != this.zStiftH) || (pWohinV != this.zStiftV))
/*     */     {
/* 122 */       if (pWohinH == this.zStiftH) {
/* 123 */         if (pWohinV > this.zStiftV)
/* 124 */           this.zWinkel = 270.0D;
/*     */         else
/* 126 */           this.zWinkel = 90.0D;
/*     */       }
/* 128 */       else if (pWohinV == this.zStiftV) {
/* 129 */         if (pWohinH > this.zStiftH)
/* 130 */           this.zWinkel = 0.0D;
/*     */         else
/* 132 */           this.zWinkel = 180.0D;
/*     */       }
/* 134 */       else if (pWohinH > this.zStiftH) {
/* 135 */         this.zWinkel = (Math.atan((pWohinV - this.zStiftV) / (this.zStiftH - pWohinH)) * 180.0D / 3.141592653589793D);
/*     */       }
/*     */       else
/*     */       {
/* 139 */         this.zWinkel = (Math.atan((pWohinV - this.zStiftV) / (this.zStiftH - pWohinH)) * 180.0D / 3.141592653589793D + 180.0D);
/*     */       }
/*     */     }
/*     */ 
/* 143 */     while (this.zWinkel < 0.0D)
/* 144 */       this.zWinkel += 360.0D;
/* 145 */     while (this.zWinkel >= 720.0D)
/* 146 */       this.zWinkel -= 360.0D;
/*     */   }
/*     */ 
/*     */   public void dreheUm(double pWinkel)
/*     */   {
/* 156 */     this.zWinkel += pWinkel;
/* 157 */     while (this.zWinkel < 0.0D)
/* 158 */       this.zWinkel += 360.0D;
/* 159 */     while (this.zWinkel >= 720.0D)
/* 160 */       this.zWinkel -= 360.0D;
/*     */   }
/*     */ 
/*     */   public void schreibeText(String pText)
/*     */   {
/* 173 */     Graphics2D g = get2DGraphics(this.kenntPrivatschirm.g());
/* 174 */     if (g != null)
/*     */     {
/* 176 */       setzeZustand(g);
/* 177 */       g.drawString(pText, (int)this.zStiftH, (int)this.zStiftV);
/* 178 */       this.zStiftH += g.getFontMetrics().stringWidth(pText);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void schreibeText(char pZeichen)
/*     */   {
/* 190 */     schreibeText("" + pZeichen);
/*     */   }
/*     */ 
/*     */   public void schreibeZahl(int pZahl)
/*     */   {
/* 201 */     schreibeText("" + pZahl);
/*     */   }
/*     */ 
/*     */   public void schreibeZahl(double pZahl)
/*     */   {
/* 212 */     schreibeText("" + pZahl);
/*     */   }
/*     */ 
/*     */   public void hoch()
/*     */   {
/* 220 */     this.zHoch = true;
/*     */   }
/*     */ 
/*     */   public void runter()
/*     */   {
/* 228 */     this.zHoch = false;
/*     */   }
/*     */ 
/*     */   public boolean istUnten()
/*     */   {
/* 236 */     return !this.zHoch;
/*     */   }
/*     */ 
/*     */   public void normal()
/*     */   {
/* 244 */     this.zSchreibModus = 0;
/*     */   }
/*     */ 
/*     */   public void radiere()
/*     */   {
/* 252 */     this.zSchreibModus = 1;
/*     */   }
/*     */ 
/*     */   public void wechsle()
/*     */   {
/* 260 */     this.zSchreibModus = 2;
/*     */   }
/*     */ 
/*     */   public double hPosition()
/*     */   {
/* 268 */     return this.zStiftH;
/*     */   }
/*     */ 
/*     */   public double vPosition()
/*     */   {
/* 276 */     return this.zStiftV;
/*     */   }
/*     */ 
/*     */   public double winkel()
/*     */   {
/* 284 */     return this.zWinkel;
/*     */   }
/*     */ 
/*     */   protected void zeichneLinie(double x1, double y1, double x2, double y2)
/*     */   {
/* 294 */     Graphics2D g = get2DGraphics(this.kenntPrivatschirm.g());
/* 295 */     if (g != null)
/*     */     {
/* 297 */       setzeZustand(g);
/* 298 */       g.draw(new Line2D.Double(x1, y1, x2, y2));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void zeichneRechteck(double pBreite, double pHoehe)
/*     */   {
/* 312 */     Graphics2D g = get2DGraphics(this.kenntPrivatschirm.g());
/* 313 */     if (g != null)
/*     */     {
/* 315 */       setzeZustand(g);
/* 316 */       g.draw(new Rectangle2D.Double(this.zStiftH, this.zStiftV, pBreite, pHoehe));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void zeichneKreis(double pRadius)
/*     */   {
/* 329 */     Graphics2D g = get2DGraphics(this.kenntPrivatschirm.g());
/* 330 */     if (g != null)
/*     */     {
/* 332 */       setzeZustand(g);
/* 333 */       g.draw(new Ellipse2D.Double(this.zStiftH - pRadius, this.zStiftV - pRadius, 2.0D * pRadius, 2.0D * pRadius));
/*     */     }
/*     */   }
/*     */ 
/*     */   private void setzeStandard()
/*     */   {
/* 343 */     this.zStiftH = 0.0D;
/* 344 */     this.zStiftV = 0.0D;
/* 345 */     this.zHoch = true;
/* 346 */     this.zWinkel = 0.0D;
/* 347 */     normal();
/*     */   }
/*     */ 
/*     */   protected void setzeZustand(Graphics2D g)
/*     */   {
/* 355 */     if (this.zSchreibModus == 1)
/*     */     {
/* 357 */       g.setPaint(this.kenntPrivatschirm.hintergrundfarbe());
/* 358 */       g.setPaintMode();
/*     */     }
/* 361 */     else if (this.zSchreibModus == 0)
/*     */     {
/* 363 */       g.setPaint(Color.black);
/* 364 */       g.setPaintMode();
/*     */     }
/*     */     else
/*     */     {
/* 368 */       g.setPaint(Color.black);
/* 369 */       g.setXORMode(this.kenntPrivatschirm.hintergrundfarbe());
/*     */     }
/* 371 */     g.setFont(Schrift.STANDARDSCHRIFT);
/*     */   }
/*     */ 
/*     */   protected Graphics2D get2DGraphics(Graphics g)
/*     */   {
/* 379 */     Graphics2D g2d = (Graphics2D)g;
/* 380 */     if (g2d != null)
/* 381 */       g2d.setStroke(this.hatStroke);
/* 382 */     return g2d;
/*     */   }
/*     */ 
/*     */   public void gibFrei()
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMEreignis.jar
 * Qualified Name:     sum.ereignis.Stift
 * JD-Core Version:    0.6.0
 */