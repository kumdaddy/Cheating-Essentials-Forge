package com.kodehawa.core;

import java.io.IOException;
import java.io.Reader;

import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

public class HTMLTextExtractor extends HTMLEditorKit.ParserCallback {
    StringBuffer s;
    
    public HTMLTextExtractor( ) {
    }
    
    public void parse( Reader in ) throws IOException {
        s = new StringBuffer( );
        ParserDelegator delegator = new ParserDelegator( );
        // the third parameter is TRUE to ignore charset directive
        delegator.parse( in, this, Boolean.TRUE );
    }
    
    @Override
    public void handleText( char[ ] text, int pos ) {
        s.append( text );
    }
    
    public String getText( ) {
        return s.toString( );
    }
    
}