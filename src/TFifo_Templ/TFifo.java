package TFifo_Templ;



public class TFifo<T>
{
    private T [] q;
    private int mMaxSize;  // ZBEDNE - mozna uzyc q.length
    private int mHead;     // indeks pierwszego elem do popbrania z kolejki
    private int mTail;     // indeks pierwzego wolnego miejsca w kolejce
    private int mElemNo;   // ilosc elementow w kolejce

    // metody analogicznie!
    //-------------

    private class TFifoItem<T> {
    private T mKey;
    private TFifoItem mNext;

    public TFifoItem() {

    }

    public TFifoItem(T key) {
        this.mKey = key;

    }

    public T getKey() {
        return this.mKey;
    }

    public TFifoItem getNext() {
        return this.mNext;
    }

    public void setNext(TFifoItem item) {
        this.mNext = item;
    }
    }
    public TFifo(int size){
        mMaxSize=size;
        mHead=0;
        mTail=0;
        mElemNo=0;

        q=<T>TFifoItem[size];//??//
    }
    public boolean  QFEmpty(){
        return mElemNo==0;
    }
    public void QFEnqueue( T x  ) throws ExceptionTFifo {

        if(mElemNo==mMaxSize)
            throw new ExceptionTFifo(ErrCode.TFIFO_OVERFLOW);
        T var= x;
        q[mTail]=var;
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
    public void  QFClear(){
        while(!QFEmpty())
            QFDequeue();
    }
    public void QFPrint(){
        int head = mHead;
        for(int i =0;i<mElemNo;i++){
            System.out.println(q[head]);
        }
    }
}

