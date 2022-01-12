package Fifo_Templ;


public class Fifo<T>
{
    private class FifoItem<T>
    {
        private T        mKey;
        private FifoItem mNext;

        public FifoItem(){

        }
        public FifoItem( T key  ){
            this.mKey=key;

        }
        public T getKey(){
            return this.mKey;
        }
        public FifoItem getNext(){
            return this.mNext;
        }
        public void setNext( FifoItem item ){
            this.mNext=item;
        }
    }
    //-------------
    public Fifo(){

    }
    public boolean  QFEmpty(){
        return mHead==null;
    }
    public void QFEnqueue( T x  ){
        try {

            if(QFEmpty()) {
                this.mHead = new FifoItem(x);
                this.mTail = this.mHead;
            }else{
                mTail.mNext=new FifoItem(x);
                this.mTail=mTail.mNext;
            }
        }catch(OutOfMemoryError e) {
            throw new ExceptionFifo(ErrCode.FIFO_OVERFLOW);
        }


    }
    public T QFDequeue() throws ExceptionFifo {
        try{
            T var = (T)mHead.mKey;
            if(mHead==mTail){
                mHead=null;
                mTail=null;
            }else{
                FifoItem p = mHead;
                mHead=p.mNext;
                p=null;
            }
            return var;

        }catch(RuntimeException e){
            throw new ExceptionFifo(ErrCode.FIFO_IS_EMPTY);
        }
    }
    public void  QFClear(){
        while(!QFEmpty())
            QFDequeue();
    }
    public void QFPrint(){
        FifoItem current=this.mHead;
        while(current!=null){
            System.out.println(current.mKey);
            current=current.mNext;
        }
    }

    private FifoItem mHead;
    private FifoItem mTail;
}
