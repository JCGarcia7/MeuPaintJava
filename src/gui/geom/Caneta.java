package gui.geom;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Caneta extends Forma {

    private List<Point> pontos;

    public Caneta() {
        pontos = new ArrayList<>();
    }
    
    @Override
    public void adicionarPonto( int x, int y ) {
        this.fimX = x;
        this.fimY = y;
        pontos.add( new java.awt.Point( x, y ) );
    }

    @Override
    public void desenhar( Graphics g ) {
        g.setColor( corContorno );
        
        if ( pontos.size() == 1 ) {
            Point p = pontos.get( 0 );
            g.drawLine( p.x, p.y, p.x, p.y );
        } else {
            for ( int i = 0; i < pontos.size() - 1; i++ ) {
                Point p1 = pontos.get( i );
                Point p2 = pontos.get( i + 1 );
                g.drawLine( p1.x, p1.y, p2.x, p2.y );
            }
        }
    }
}