package Fifo_Templ;


public class Fifo<T>
{
    private class FifoItem<T>
    {
        private T        mKey;
        private FifoItem mNext;

        public FifoItem(){
            mNext=null;
        }
        public FifoItem( T key  ){
           mKey=key;
            mNext=null;
        }
        public T getKey(){
            return mKey;
        }
        public FifoItem getNext(){
            return mNext;
        }
        public void setNext( FifoItem item ){
            mNext=item;
        }
    }
    //-------------
    public Fifo() throws ExceptionFifo{
        try{
            mHead=mTail=new FifoItem<T>();
        }catch(OutOfMemoryError e){
            throw new ExceptionFifo(ErrCode.FIFO_ALLOCATION);
        }
    }
    public boolean  QFEmpty(){
        return mHead.getNext()==null;
    }
    public void QFEnqueue( T x  ){
        try {
           mTail.setNext(new FifoItem(x));
        }catch(OutOfMemoryError e) {
            throw new ExceptionFifo(ErrCode.FIFO_ALLOCATION);
        }
        mTail=mTail.getNext();
    }
    public T QFDequeue() throws ExceptionFifo {

        if(!QFEmpty()){
            T x = (T)(mHead.getNext().getKey());
            mHead=mHead.getNext();
            if(QFEmpty()) mTail=null;
            return x;
        }
        throw new ExceptionFifo(ErrCode.FIFO_IS_EMPTY);
    }
    public void  QFClear(){
        while(!QFEmpty())
            QFDequeue();
        mHead=mTail=null;
    }
    public void QFPrint(){
        FifoItem current=mHead.getNext();
        while(current!=null){
            System.out.println(current.getKey().toString());
            current=current.getNext();
        }
    }

    private FifoItem mHead;
    private FifoItem mTail;
}
