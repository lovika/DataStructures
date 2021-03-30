#include <bits/stdc++.h>
#include <iostream>
using namespace std;

int* harr = new int[10];
int harr_size = 0;

int swap(int i1, int i2) {
    harr[i1] = harr[i1] + harr[i2];
    harr[i2] = harr[i1] - harr[i2];
    harr[i1] = harr[i1] - harr[i2];
}

int parent(int i) {
	return (i-1)/2;
}

void minHeapify(int root) {
    int l = 2*root + 1;
    int r = 2*root + 2;
    int smallest = root;
    if(l < harr_size && harr[l] < harr[smallest]) {
        smallest = l;
    }
    if(r < harr_size && harr[r] < harr[smallest]) {
        smallest = r;
    }

    if(root!=smallest) {
    	swap(smallest, root);
    	minHeapify(smallest);
    }
}

void insertKey(int val) {
	harr[harr_size++] = val;
    int i = harr_size - 1;
    while(i > 0 && harr[i] < harr[parent(i)]) {
        swap(i, parent(i));
        i = parent(i);
    }
}

int extractMin() {
    if(harr_size <= 0)
        return INT_MAX;

    if(harr_size == 1) {
        harr_size--;
        return harr[0];
    }

    int root = harr[0];
    harr[0] = harr[harr_size-1];
    harr_size--;
    minHeapify(0);
    return root;
}

int getMin() {
    return harr[0];
}

void decreaseKey(int key, int val) {
    harr[key] = val;
    int i = key;
    while(i !=0 && harr[parent(i)] > harr[i] ) {
        swap(parent(i), i);
        i = parent(i);
    }
}

void deleteKey(int key) {
    decreaseKey(key, INT_MIN);
    extractMin();
}


int main()
{
    insertKey(3);
    insertKey(2);
    deleteKey(1);
    insertKey(15);
    insertKey(5);
    insertKey(4);
    insertKey(45);
    cout << extractMin() << " ";
    cout << getMin() << " ";
    decreaseKey(2, 1);
    cout << getMin();

	return 0;
}
