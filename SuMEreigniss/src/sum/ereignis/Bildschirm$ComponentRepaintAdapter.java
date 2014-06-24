package sum.ereignis;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

class Bildschirm$ComponentRepaintAdapter implements ComponentListener {

    private Bildschirm zBildschirm;

    private Bildschirm$ComponentRepaintAdapter(Bildschirm paramBildschirm) {
        paramBildschirm.repaint();
    }

    @Override
    public void componentMoved(ComponentEvent event) {
        zBildschirm.repaint();
        event.getComponent().repaint();

    }

    @Override
    public void componentResized(ComponentEvent event) {
        zBildschirm.repaint();
        event.getComponent().repaint();
    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
