package template_fifo_tfifo;

import Fifo_Templ.Fifo;
import Fifo_Templ.ExceptionFifo;
import TFifo_Templ.TFifo;
import TFifo_Templ.ExceptionTFifo;


public class Main {

    public static void main(String[] args) {
	// write your code here
        Fifo<Integer> f=new Fifo<Integer>();
        Double t[]={1.2,2.3,3.4,4.5};
        TFifo<Double> tf=new TFifo<Double>(t);

        try {
            f.QFEnqueue(1);
            f.QFEnqueue(2);
            f.QFEnqueue(3);
            f.QFPrint();

        }
        catch(ExceptionFifo e){
            System.out.println(e.getReason());
        }

        try {


            tf.QFEnqueue(1.5);
            tf.QFEnqueue(2.6);
            tf.QFEnqueue(3.7);
            tf.QFPrint();
        }
        catch(ExceptionTFifo e){
            System.out.println(e.getReason());
        }

    }
}

/*
Projekt FIFO
  zawiera dwa pakiet Fifo_Templ - klasy Fifo i ExceptionFifo
                     TFifo_Templ - klasy TFifo i TExceptionFifo (identyczna jak ExceptionFifo)

Fifo - lista prosta
//--------------------------------------------
//FIFO z glowa
public class Fifo<T>
{
private class FifoItem<T>
{
 private T        mKey;
 private FifoItem mNext;

 public FifoItem()
 public FifoItem( T key  )
 public T getKey()
 public FifoItem getNext()
 public void setNext( FifoItem item )
}
//-------------
public Fifo()
public boolean  QFEmpty()
public void QFEnqueue( T x  )
public T QFDequeue() throws ExceptionFIFO
public void  QFClear()
public void QFPrint()

private FifoItem mHead;
private FifoItem mTail;
}




TFifo - tablicowo

public class TFifo<T>
{
  private T [] q;
  private int mMaxSize;  // ZBEDNE - mozna uzyc q.length
  private int mHead;     // indeks pierwszego elem do popbrania z kolejki
  private int mTail;     // indeks pierwzego wolnego miejsca w kolejce
  private int mElemNo;   // ilosc elementow w kolejce

// metody analogicznie!
}

 */
