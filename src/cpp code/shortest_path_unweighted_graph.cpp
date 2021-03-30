// Shortest path from src to destination in an unweighted directed graph

#include <bits/stdc++.h>
#include <iostream>
using namespace std;

void addEdge(vector<int> adj[], int src, int dest);
void printShortestPath(vector<int> adj[], int src, int dest, int V);
bool BFS(vector<int> adj[], int src, int dest, int V, int pred[], int dist[]);

void addEdge(vector<int> adj[], int src, int dest) {
  adj[src].push_back(dest);
}

bool BFS(vector<int> adj[], int src, int dest, int V, int pred[], int dist[]) {
  for(int i = 0; i< V; i++) {
    pred[i] = -1;
    dist[i] = INT_MAX;
  }

  queue<int> que;
  dist[src] = 0;
  que.push(src);

  while(!que.empty()) {
    int curr = que.front();
    que.pop();
    for(int i = 0; i < adj[curr].size(); i++) {
      if(pred[adj[curr][i]] == -1) {
        pred[adj[curr][i]] = curr;
        dist[adj[curr][i]] = dist[curr] + 1;
        que.push(adj[curr][i]);
        if( adj[curr][i] == dest)
          return true;
      }
    }
  }

  return false;
}

void printShortestPath(vector<int> adj[], int src, int dest, int V) {
  int pred[V], dist[V];
  if(!BFS(adj, src, dest, V, pred, dist)) {
    cout<<"Source and destination are not connected";
    return;
  }

  vector<int> arr;
  arr.push_back(dest);
  int i = dest;
  while(pred[i]>=0) {
    arr.push_back(pred[i]);
    i = pred[i];
  }

  cout<<"Shorted Path length : "<<dist[i]<<endl;
  cout<<"Shortest Path : ";

  for(int i = arr.size()-1; i >=0;i--) {
    cout<<arr[i]<<" ";
  }
}

int main()
{
int V = 8;
vector<int> adj[V];
addEdge(adj, 0, 1);
addEdge(adj, 1, 2);
addEdge(adj, 1, 3);
addEdge(adj, 2, 4);
addEdge(adj, 3, 5);
addEdge(adj, 3, 8);
addEdge(adj, 4, 5);
addEdge(adj, 4, 6);
addEdge(adj, 5, 6);
addEdge(adj, 6, 7);
addEdge(adj, 5, 7);

int src = 0, dest = 7;
printShortestPath(adj, src, dest, V);
return 0;
}
