package TFifo_Templ;



public class TFifo<T>
{
    private T [] q;
    private int mMaxSize;  // ZBEDNE - mozna uzyc q.length
    private int mHead;     // indeks pierwszego elem do popbrania z kolejki
    private int mTail;     // indeks pierwzego wolnego miejsca w kolejce
    private int mElemNo;   // ilosc elementow w kolejce

    // metody analogicznie!

    public TFifo(T[] queue){
        q=queue;
        mMaxSize= queue.length;
        mHead = mTail = mElemNo = 0;

    }
    public boolean  QFEmpty(){
        return mElemNo==0;
    }
    public void QFEnqueue( T x  ) throws ExceptionTFifo {

        if(mElemNo>=mMaxSize)
            throw new ExceptionTFifo(ErrCode.TFIFO_OVERFLOW);

        q[mTail]=x;
        mTail=(mTail+1)%mMaxSize;
        mElemNo++;

    }
    public T QFDequeue() throws ExceptionTFifo{
        if(QFEmpty())
            throw new ExceptionTFifo(ErrCode.TFIFO_IS_EMPTY);
        T var=q[mHead];

        q[mHead]=null;
        mHead=(mHead+1)%mMaxSize;
        mElemNo--;

        return var;
    }
    public void QFClear(){
        while(!QFEmpty())
            del();
        mHead=mTail=0;
    }
    public void QFPrint(){

        for (int i=mHead;;){
            if(i==mTail) break;
            System.out.println(q[i]);
            i=(i+1)%mMaxSize;
        }
    }
    private void del(){
        if(QFEmpty())
            throw new ExceptionTFifo(ErrCode.TFIFO_IS_EMPTY);
        q[mHead]=null;
        mElemNo--;
        mHead=(mHead-1)%mMaxSize;
    }
}

