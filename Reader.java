package Reader;

import java.io.IOException;
import java.io.PushbackInputStream;
public class Reader
{
    private static PushbackInputStream pushbackInputStream = new PushbackInputStream(System.in);
    /**
     * Reads one character from the input stream System.in
     * @return  returns read character
     */
    public static char getChar() throws IOException  // only one char could be ungetted
    {  // read()
        try
        {
            return (char) pushbackInputStream.read();
        }
        catch (IOException ex)
        {
            throw new IOException("Error while getting char");
        }

    }

    /**
     * Returns one character to the input for reloading. Only one char could be returned!
     * @param c - zwracany znak do ponownego odczytu
     */
    public static void ungetChar( char c ) throws IOException
    {
        try
        {
            pushbackInputStream.unread((int) c);
        }
        catch (IOException ex)
        {
            throw new IOException("Error while ungetting char");
        }
    }

    /**
     * Reads the integer value written in char case
     * @return return the value of integer  number
     */
    public static int readInt() throws IOException
    {
        //czy znak - fun
        // czytanie liczby bez znaku - fun
        // zwrocic wart (return)

        boolean isNegative = getSign();
        int res = readNum();
        if(isNegative)
            res = -res;
        return res;
    }

    /**
     * Reads the double value written in char case
     * @return the value of double  num
     */
    public static double readDouble() throws IOException
    {
        //czy znak - fun
        // czytanie cechy fun
        // czytanie mantysy
        //na koncu zwraca znak
        // zwrocenie wyniku (return)
        double res = 0;
        boolean isNegative = getSign();
        res = readInt();
        char delim = getChar();
        if (!(delim == ',' || delim == '.'))
        {
            throw new IOException("Error - wrong format");
        }
        double doubleres = 0;
        double coef = 0.1;
        char c = getChar();
        while (isDecDigit(c))
        {
            doubleres = doubleres + coef * charDecDigit2Int(c);
            c = getChar();
            coef *= 0.1;
        }
        res += doubleres;
        ungetChar(c);
        if(isNegative)
            res = -res;
        return res;
    }

    /**
     * Reads the hexadecimal value written in char case
     * @return returns value of proper hexadecimal value
     */
    public static int readHex() throws IOException
    {
        // poprzedajaca biale znaki
        //sprawdzic czy format 0x 0X
        // Horner petla z jedna instr
        //na koncu zwraca znak
        //return wynik

        skipSpaces();
        if(!(getChar() == '0' && getChar() == 'x'))
        {
            throw new IOException("Error - wrong format");
        }
        skipSpaces();
        int res = 0;
        char c = getChar();
        while (isHexDigit(c))
        {
            if(isDecDigit(c))
            {
                res = res * 16 + charDecDigit2Int(c);
            }
            else
            {
                res = res * 16 + charHexDigit2Int(c);
            }
            c = getChar();
        }
        ungetChar(c);
        return res;
    }

    //================ P R I V A T E INTERFACE ==========================================
    private static int readNum() throws IOException
    {
        //czytanie liczby calk bez znaku poprzedz bialymi znakami
        //na koncu zwraca znak
        skipSpaces();
        int res = 0;
        char c = getChar();
        while (isDecDigit(c))
        {
            res = res * 10 + charDecDigit2Int(c);
            c = getChar();
        }
        ungetChar(c);
        return res;

    }

    private static boolean getSign() throws IOException
    {
        //czytanie znaku poprzedz bialymi znakami
        //jak byl minus to zwraca true
        //na koncu zwraca znak jesli nie wylo '-'

        skipSpaces();
        char c = getChar();
        if (c == '-')
        {
            return true;
        }
        ungetChar(c);
        return false;
    }
    private static void skipSpaces() throws IOException {
        // pomija spacje tabulatroy CR-y, LF-dy
        //na koncu zwraca znak
        char c=getChar();
        while (c== ' ' || c== '\t' ||c == '\r' ||c == '\n'){
            c=getChar();
        }
        ungetChar(c);
    }

    //  W PONIZSZYCH FUNKCJACH JELSI MOZLIWE TO WYWOLYWAC FUNCKJE TU ZDEFINIOWANE
    //   NP isHexDigit POWINNA KORZYSTAC Z isDecDigit
    private static boolean isDecDigit( char c )
    {
        return (c>='0') && (c<='9');
    }

    private static boolean isHexDigit( char c ) { return isDecDigit(c) || isHexLetter(c); }

    private static char upperCase( char c )
    {
        return (c>='A' && c <='Z')? c : (char) (c - 32);
    }

    private static boolean isHexLetter( char c )
    {
        return (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f');
    }

    private static int charDecDigit2Int( char c )
    {
        return (int) c - 48;
    }

    private static int charHexDigit2Int( char c )
    {
        //jenda instr return . . . .   (w tej jednej instr ma c zamianac na upperCase) // ma wywolac charDecDigit2Int
        return charDecDigit2Int(upperCase(c)) - 7;
    }

}//end of class
