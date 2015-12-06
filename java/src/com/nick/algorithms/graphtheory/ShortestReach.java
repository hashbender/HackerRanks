package com.nick.algorithms.graphtheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author nick.hansen
 *
 */
public class ShortestReach {
	public interface Node {
		void addEdge(Node n);
		public List<Node> getNeighbors();
		public int getData();
		public void setDistance(int n );
		public int getDistance();
		public boolean visited();
		public void setVisited(boolean b);
	}
	public static class NodeImpl implements Node, Comparable<Node> {
		List<Node> neighbors;
		int position;
		int distance = Integer.MAX_VALUE;
		boolean visited = false;
		public NodeImpl(int i){
			position = i;
			this.neighbors = new ArrayList<Node>();
		}
		
		public void addEdge(Node i){
			for (Node n : neighbors) {
				// you tricky little shits
				// makes sure we don't have duplicate edges
				if (n.getData() == i.getData())
					return;
			}
			neighbors.add(i);
		}
		
		public List<Node> getNeighbors(){
			return neighbors;
		}
		
		public int getData(){
			return position;
		}
		public void setDistance(int n){
			this.distance = n;
		}
		public int getDistance(){
			return this.distance;
		}

		@Override
		public boolean visited() {
			return visited;
		}

		@Override
		public void setVisited(boolean b) {
			this.visited = b;
		}

		@Override
		public int compareTo(Node arg0) {
			return Integer.compare(distance, arg0.getDistance());
		}
	}

	public static void findDistance(Node fromNode) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		fromNode.setDistance(0);
		queue.add(fromNode);
		while (!queue.isEmpty()) {
			Node n = (Node) queue.poll();
			for (Node f : n.getNeighbors()) {
				int weight = 6;
				int throughU = n.getDistance() + weight;
				if (throughU < f.getDistance()) {
					queue.remove(f);
					f.setDistance(throughU);
					queue.add(f);
				}
			}
		}
	}
    
    public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			br.readLine();
			String line;
			Map<Integer, Node> nodeMap = new HashMap<Integer, Node>();
			while ((line = br.readLine()) != null && line.length() > 0) {
				line = line.trim();
				int numNodes = Integer.parseInt(line.split(" ")[0]);
				int numEdges = Integer.parseInt(line.split(" ")[1]);
				for (int i = 1; i <= numNodes; i++){
					nodeMap.put(i, new NodeImpl(i));
				}
				
				//Add edges to all the nodes. 
				for (int i = 0; i < numEdges; i++) {
					line = br.readLine();
					line = line.trim();
					int from = Integer.parseInt(line.split(" ")[0]);
					int to = Integer.parseInt(line.split(" ")[1]);
					Node fromNode = nodeMap.get(from);
					Node toNode = nodeMap.get(to);
					fromNode.addEdge(toNode);
					toNode.addEdge(fromNode);
				}
				
				int startAt = Integer.parseInt(br.readLine().trim());
				Node startNode = nodeMap.get(startAt);
				
				findDistance(startNode);
				
				StringBuffer buff = new StringBuffer();
				for (int i = 1; i <= numNodes; i++){
					if (i != startAt)
						if (nodeMap.get(i).getDistance() == Integer.MAX_VALUE){
							buff.append("-1 ");
						} else {
							buff.append(nodeMap.get(i).getDistance() + " ");
						}
				}
				System.out.println(buff.toString().trim());
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
