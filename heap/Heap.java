interface Heap{

    void sort();
    void buildHeap();
    int getHeapSize();		
    void heapify(int i);	//maintains heap property of subtree at index i
    void insert(int key);
    void delete(int node);  
    int parent(int child);  
    int leftChild(int parent);	
    int rightChild(int parent); 
}