public class MyLinkedList<E> 
{
    private Node<E> head, tail;
    
    public void append(E item)
    {
        Node<E> newNode = new Node<>(item);
        
        if(head==null)
        {
            head=tail=null;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    public MyLinkedList()
    {
        head=tail=null;
    }
        
    private static class Node<E>
    {
        E element;
        Node<E> next;
            
        public Node(E element)
        {
            this.element= element;
            next=null;
        }
    }
    
    public MyLinkedList merge(MyLinkedList paramList)
    {
        MyLinkedList returnList = new MyLinkedList();
        Node<E> ptrCurrent,ptrParammeter;                   //declaring two pointers to traverse both list 
        ptrCurrent=head;
        ptrParammeter= paramList.head;
        
        if(head==null)                                  //calling list is empty
        {
            while(ptrParammeter!=null)
            {
                returnList.append(ptrParammeter.element);
                ptrParammeter=ptrParammeter.next;
            }
            return returnList;
        }
        if(ptrParammeter==null)                         //parameter list is empty
        {
            while(ptrCurrent!=null)
            {
                returnList.append(ptrCurrent.element);
                ptrParammeter=ptrCurrent.next;
            }
            return returnList;
        }
        
        while((ptrCurrent!=null) && (ptrParammeter!=null)) //continue up until the end of the list
        {
            if(((Comparable)ptrCurrent.element).compareTo(ptrParammeter.element)<=0)
            {
                returnList.append(ptrCurrent.element);
                ptrCurrent = ptrCurrent.next;
            }
            else
            {
                returnList.append(ptrParammeter.element);
                ptrParammeter = ptrParammeter.next;
            }
        }
        
        if(ptrCurrent==null)                                //copy the rest of the parameter list
        {
            while(ptrParammeter!=null)
            {
                returnList.append(ptrParammeter.element);
                ptrParammeter=ptrParammeter.next;
            }
        }
        if(ptrParammeter==null)                             //copy the rest of the calling list
        {
            while(ptrCurrent!=null)
            {
                returnList.append(ptrCurrent.element);
                ptrParammeter=ptrCurrent.next;
            }
        }
        return returnList;
    }
}