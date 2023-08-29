/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jgsoftware.jdesktop.telnet;


// java telnet hostname [port]

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

// A terminal displays text in a window, scrolling up as needed
class Terminal extends Canvas {
    private int charWidth, charHeight;  // Font size
    private String[] text;  // text[0] is current line at bottom
    private final int margin=4;  // Space around window edge (pixels)
    private final int lines=50;  // Number of lines to save

    // Constructor, set initial size (in chars) and font
    
    
    Terminal() {
        charHeight=12;
        setFont(new Font("Monospaced", Font.PLAIN, charHeight));
        charWidth=getFontMetrics(getFont()).stringWidth(" ");
        text=new String[lines];
        for (int i=0; i<lines; ++i)
            text[i]="";
        setSize(80*charWidth+margin*2, 25*charHeight+margin*2);
        requestFocus();

        // Use mouse to grab focus
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                requestFocus();
            }
        });
    }

    // Print a character and save in text
    public void put(char c) {
        Graphics g=getGraphics();
        if (c=='\r') {  // Return
            for (int i=lines-1; i>0; --i)
                text[i]=text[i-1];
            text[0]="";
            update(g);  // Clear screen and paint
        }
        else if (c==8 || c==127 || c==247)  // Backspace, delete, telnet EC
        {
            int len=text[0].length();
            if (len>0) {
                --len;
                text[0]=text[0].substring(0, len);
                g.setColor(getBackground());
                g.fillRect(len*charWidth+margin, getSize().height-margin-charHeight,
                        (len+1)*charWidth+margin, getSize().height-margin);
            }
        }
        else if (c=='\t') {  // Tab column to next multiple of 8
            text[0]+="        ";
            text[0].substring(0, text[0].length()&-8);
        }
        else if (c>=32 && c<127) {  // Printable character
            g.drawString(""+c, margin+text[0].length()*charWidth,
                    getSize().height-margin);
            text[0]+=c;
        }
        g.dispose();
    }

    // Display the text
    public void paint(Graphics g) {
        int height=getSize().height;
        for (int i=0; i<lines; ++i)
            g.drawString(text[i], margin, height-margin-i*charHeight);
    }
}

// A Receiver thread waits for characters from an InputStream and
// sends them to a Terminal.  Also, negotiate terminal options.
class Receiver extends Thread {
    private InputStream in;
    private OutputStream out;
    private Terminal terminal;

    public Receiver(InputStream in, OutputStream out, Terminal terminal) {
        this.in=in;
        this.out=out;
        this.terminal=terminal;
        start();
    }

    // Read characters and send to terminal, negotiate no options
    public void run() {
        while (true) {
            try {
                int c=in.read();
                if (c<0) {  // EOF
                    System.out.println("Connection closed by remote host");
                    return;
                }
                else if (c==255) {  // Negotiate terminal options (RFC 854)
                    int c1=in.read();  // 253=do, 251=will
                    int c2=in.read();  // option
                    if (c1==253)  // do option, send "won't do option"
                        out.write(new byte[] {(byte)255, (byte)252, (byte)c2});
                    else if (c1==251) // will do option, send "don't do option"
                        out.write(new byte[] {(byte)255, (byte)254, (byte)c2});
                }
                else
                    terminal.put((char)c);
            }
            catch (IOException x) {
                System.out.println("Receiver: "+x);
            }
        }
    }
}

// TelnetWindow.  Send keyboard input from a terminal to a remote socket,
// and start a Receiver to receive characters from the socket and print
// them on the terminal.
public class TelnetWindow extends javax.swing.JInternalFrame 
{
    Terminal terminal;
    InputStream in;
    OutputStream out;

    
    public String hostname = "192.168.10.56";
    public int port=23;
    
    // Constructor, no other methods
    public TelnetWindow() 
    {
      
        
      
        // Set up the window
        add(terminal = new Terminal());

   


        /*


        try {
          terminal.put(k);
          out.write((int)k);
          if (k=='\r') {
            out.write('\n');  // Convert CR to CR-LF
            out.flush();
          }
        }
        catch (IOException x) {
          System.out.println("Send: "+x);
        }

         */

        // Handle keys
        terminal.addKeyListener(new KeyAdapter()
        {
            public void keyTyped(KeyEvent e)
            {
                char k= e.getKeyChar();
                try {

                    out.write((int)k);
                    if (k=='\r') {
                        out.write('\n');  // Convert CR to CR-LF
                        terminal.put(k);
                        out.flush();
                    }
                }
                catch (IOException x) {
                    System.out.println("Send: "+x);
                }
            }
        });

        try {

            // Open a connection
            System.out.println("Opening connection to "+hostname+" on port "+port);
            Socket socket=new Socket(hostname, port);
            InetAddress addr=socket.getInetAddress();
            System.out.println("Connected to "+addr.getHostAddress());
            in=socket.getInputStream();
            out=socket.getOutputStream();

            // Show window
            pack();
            setVisible(true);

            // Start the Receiver
            new Receiver(in, out, terminal);
            System.out.println("Ready");
        }
        catch (UnknownHostException x) {
            System.out.println("Unknown host: "+hostname+" "+x);
            System.exit(1);
        }
        catch (IOException x) {
            System.out.println(x);
            System.exit(1);
        }
    }
   
}
