/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import gui.estrutura.ResizingArrayStack;
import gui.geom.Forma;
import gui.geom.Linha;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Júlio César Dias Garcia
 */
public class PainelDesenho extends JPanel {
    
    private ResizingArrayStack<Forma> pilhaUndo;
    private ResizingArrayStack<Forma> pilhaRedo;
    
    public PainelDesenho() {
        pilhaUndo = new ResizingArrayStack<>();
        pilhaRedo = new ResizingArrayStack<>();
    }

    @Override
    protected void paintComponent( Graphics g ) {
        
        super.paintComponent( g );
        
        g.setColor( Color.WHITE );
        g.fillRect( 0, 0, getWidth(), getHeight() );
        
        for ( int i = 0; i < pilhaUndo.getTamanho(); i++ ) {
            Forma forma = pilhaUndo.get( i );
            if ( forma != null ) {
                forma.desenhar( g );
            }
        }
        
    }
    
    public void adicionarForma( Forma forma ) {
        pilhaUndo.push( forma );
        pilhaRedo.clear();
    }
    
    public void desfazer() {
        if ( !pilhaUndo.isEmpty() ) {
            Forma forma = pilhaUndo.pop();
            pilhaRedo.push( forma );
            repaint();
        }
    }
    
    public void refazer() {
        if ( !pilhaRedo.isEmpty() ) {
            Forma forma = pilhaRedo.pop();
            pilhaUndo.push( forma );
            repaint();
        }
    }
    
    public boolean podeDesfazer() {
        return !pilhaUndo.isEmpty();
    }

    public boolean podeRefazer() {
        return !pilhaRedo.isEmpty();
    }
    
}
