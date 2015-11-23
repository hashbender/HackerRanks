#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <string>
#include <map>
#include <list>
using namespace std;

#define EDGE_LENGTH 6


class Graph {
public:
    Graph(int numNodes, int numEdges) { this->numNodes = numNodes; this->numEdges = numEdges;};
    ~Graph() {};
    
    string getShortestDistances (int startingNode) {
        string distances;
        vector<int> distanceList(numNodes, -1);
        
        //cout << "Calculating distances from " << startingNode << endl;
        
        // Calculate shortest depth to each node from the starting node
        calcDistances(startingNode, distanceList);
        
        // Format the output string
        for (int i=0; i<distanceList.size(); i++) {
            if (i == (startingNode-1)) {
                continue;
            }
            
            if (distanceList[i] == -1) {
                distances += to_string(distanceList[i]) + " ";
            } else {
                distances += to_string(distanceList[i] * EDGE_LENGTH) + " ";
            }
        }
        
        // There's an extra space at the end if we had more than the starting node in the graph
        if (!distances.empty()) {
            distances.pop_back();
        }
        
        return distances;
    };
    
    void addEdge(int a, int b) {
        graphMap[a].push_back(b);
        graphMap[b].push_back(a);
        
        //cout << "Added edge from " << a << " to " << b << endl;
    };
    
private:
    int numNodes;
    int numEdges;
    
    map<int, list<int> > graphMap;
    
    void calcDistances(int startingNode, vector<int> &distanceList) {
        vector<bool> visited(numNodes, false);
        
        visited[startingNode-1] = true;
        distanceList[startingNode-1] = 0;
        
        recurseNode(startingNode, 1, visited, distanceList);
    }
    
    
    void recurseNode(int node, int depth, vector<bool> &visited, vector<int> &distanceList) {
        list<int>::iterator foundNode = graphMap[node].begin();
        
         //cout << "Recursing " << node << endl;
        
        // Iterate through connected nodes
        while(foundNode != graphMap[node].end()) {
            //cout << "Found " << *foundNode << " from " << node << endl;
            nodeFound(*foundNode, depth, distanceList);
        
            // We want to avoid cyclic recursion in the graph, so if a node is already marked as visted ignore it
            if (!visited[*foundNode - 1]) {
                visited[*foundNode - 1] = true;
                
                // Each level of recursion increments the depth
                recurseNode(*foundNode, depth+1, visited, distanceList);
            }
            
            foundNode++;
        }
    }
    
    
    void nodeFound(int node, int depth, vector<int> &distanceList) {
        if (distanceList[node - 1] == -1 || 
            depth < distanceList[node - 1]) {
            distanceList[node - 1] = depth;
            //cout << "Updated Node: " << node << " Depth: " << depth << endl;
        }
    }
};


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */  
    
    int numTestCases;
    
    cin >> numTestCases;
    
    for (int i=0; i<numTestCases; i++) {
        Graph *graph;
        int numNodes, numEdges;
        int startingNode;
        
        cin >> numNodes >> numEdges;
        
        graph = new Graph(numNodes, numEdges);
        
        for (int j=0; j<numEdges; j++) {
            int a, b;
            
            cin >> a >> b;
            
            graph->addEdge(a, b);
        }
        
        cin >> startingNode;
        
        cout << graph->getShortestDistances(startingNode) << endl;
        
        delete graph;
    }
    
    return 0;
}