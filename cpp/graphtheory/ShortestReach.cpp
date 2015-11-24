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
    Graph(int numNodes, int numEdges) {this->numNodes = numNodes;  this->numEdges = numEdges;};
    ~Graph() {};
    
    string getShortestDistances (int startingNode) {
        string distances;
        vector<int> distanceList(numNodes, -1);
        
         map<int, list<int> >::iterator curNode = graphMap.begin();
 
        // Remove duplicate edges
        while(curNode != graphMap.end()) {
            curNode->second.sort();
            curNode->second.unique();
            
            curNode++;
        }
        
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
    
    void print() {
        map<int, list<int> >::iterator curNode = graphMap.begin();
        
        cout << endl << endl;
        cout << "Graph Map: " << endl << endl;
        
        while(curNode != graphMap.end()) {
            cout << curNode->first << ": ";
            list<int>::iterator curNeighbor = curNode->second.begin();
            
            while(curNeighbor != curNode->second.end()) {
                cout << *curNeighbor << " ";
                curNeighbor++;
            }
            
            cout << endl << endl;
            curNode++;
        }
    }
    
private:
    int numNodes;
    int numEdges;
    
    map<int, list<int> > graphMap;
    
    void calcDistances(int startingNode, vector<int> &distanceList) {
        map<int, list<int> > depthMap;
        distanceList[startingNode-1] = 0;
        
        depthMap[0].push_front(startingNode);
        
        int numNodesFound = 1;
        recurseNode(depthMap, 0, distanceList, numNodesFound);
    }
    
    
    void recurseNode(map<int, list<int> > &depthMap, int depth, 
                     vector<int> &distanceList, int &numNodesFound) {      
        // For each node at this depth
        list<int>::iterator curDepthNode = depthMap[depth].begin();
        while (curDepthNode != depthMap[depth].end()) {
        
            // For each neighbor connected to this node
            list<int>::iterator nodeNeighbor = graphMap[*curDepthNode].begin();
            while(nodeNeighbor != graphMap[*curDepthNode].end()) {
                //cout << "Found " << *foundNode << " from " << node << endl;
                if (nodeFound(*nodeNeighbor, depth+1, distanceList)) {
                    // If this is a new node, add it to the list of nodes to process, 
                    // since we want the shortest distance, we only need to process new 
                    // nodes that we've encountered
                    depthMap[depth+1].push_back(*nodeNeighbor);
                    numNodesFound++;
                }
        
                nodeNeighbor++;
            }
            
            // We've looked at all the node neighbors
            curDepthNode++;
        }
        
        // We've looked at all the nodes at the current depth
        
        // If we have not yet found all the nodes in the graph, recurse to the next level
        if (numNodesFound != numNodes &&
           !depthMap[depth+1].empty()) {
            recurseNode(depthMap, depth+1, distanceList, numNodesFound);
        }  
    }
    
    
    bool nodeFound(int node, int depth, vector<int> &distanceList) {
        if (distanceList[node - 1] == -1) {
            distanceList[node - 1] = depth;

           return true;
        }
        
        return false;
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
       
        //graph->print();
        
        delete graph;
    }
    
    return 0;
}
