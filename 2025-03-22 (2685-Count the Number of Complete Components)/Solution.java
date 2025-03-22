class Solution {
    public void printEdges(boolean[] visited, int[][] edges) {
        System.out.print("[ ");
        for(int i=0; i< visited.length; i++) {
            if(visited[i] == true)  continue;
            System.out.print("[");
            System.out.print(edges[i][0] +"," + edges[i][1]);
            System.out.print("]");
        }
        System.out.println(" ]");
    }
    public int countCompleteComponents(int n, int[][] edges) {
        // Beats 19%
        if( n == 1 || n == 2) {
            if( edges.length == 1) return 1;
            else return n;
        }

        Set visited = new HashSet<Integer>();
        int finalAns = 0;

        boolean[] edgesVisited = new boolean[edges.length];
        int edgesVisitedCount = 0;


        while(edgesVisitedCount < edges.length) {

            int pointer = 0;
            while(pointer < edges.length && edgesVisited[pointer] == true)   pointer++;

            Set currentlyVisited = new HashSet<Integer>();
            int currentEdgeCount = 0;
            // First edge
            visited.add(edges[pointer][0]);
            visited.add(edges[pointer][1]);
            currentlyVisited.add(edges[pointer][0]);
            currentlyVisited.add(edges[pointer][1]);
            currentEdgeCount++;
            edgesVisited[pointer] = true;
            edgesVisitedCount++;
            
            boolean changed = true;
            // Iterate through edges
            while( changed ) {
                changed = false;
                for(int i = 0; i < edges.length; i++) {
                    // Already visited, skip
                    if(edgesVisited[i])   continue;

                    // If any edge is already in currentlyVisited
                    if(currentlyVisited.contains(edges[i][0]) || 
                    currentlyVisited.contains(edges[i][1])) {
                        // add edges to currenly Visited
                        currentlyVisited.add(edges[i][0]);
                        currentlyVisited.add(edges[i][1]);

                        visited.add(edges[i][0]);
                        visited.add(edges[i][1]);

                        currentEdgeCount++;
                        edgesVisited[i] = true;
                        edgesVisitedCount++;

                        // remove edge from edges
                        changed = true;

                    }
                }
            }

            // Edges required are n*(n-1)/2
            int edgesNeeded = currentlyVisited.size() * (currentlyVisited.size()-1) / 2;
            if(edgesNeeded == currentEdgeCount)  finalAns++;

            // printEdges(edgesVisited, edges);
            // System.out.println(currentEdgeCount + " " + edgesNeeded + " " + finalAns);
        }

        // System.out.println(finalAns);
        // System.out.println(visited);
        finalAns += (n - visited.size());

        return finalAns;




        // Correct Solution (Beats 11%)
        // if( n == 1 || n == 2) {
        //     if( edgesOld.length == 1) return 1;
        //     else return n;
        // }
        // // Add edges to linkedlist
        // List<List<Integer>> edges = new ArrayList<>();
        // for(int[] edge: edgesOld) {
        //     List temp = new ArrayList<Integer>();
        //     temp.add(edge[0]);
        //     temp.add(edge[1]);
        //     edges.add(temp);
        // }

        // Set visited = new HashSet<Integer>();
        // int finalAns = 0;

        // while(edges.size() > 0) {
        //     Set currentlyVisited = new HashSet<Integer>();
        //     int currentEdgeCount = 0;
        //     // First edge
        //     List edge = edges.get(0);
        //     currentlyVisited.add(edge.get(0));
        //     currentlyVisited.add(edge.get(1));


        //     visited.add(edge.get(0));
        //     visited.add(edge.get(1));
        //     currentEdgeCount++;
        //     edges.remove(0);
            
        //     boolean changed = true;
        //     // Iterate through edges
        //     while( changed ) {
        //         changed = false;
        //         for(int pointer = 0; pointer < edges.size(); pointer++) {
        //             edge = edges.get(pointer);
        //             // If any edge is already in currentlyVisited
        //             if(currentlyVisited.contains(edge.get(0)) || 
        //             currentlyVisited.contains(edge.get(1))) {
        //                 // add edges to currenly Visited
        //                 currentlyVisited.add(edge.get(0));
        //                 currentlyVisited.add(edge.get(1));

        //                 visited.add(edge.get(0));
        //                 visited.add(edge.get(1));

        //                 currentEdgeCount++;

        //                 // remove edge from edges
        //                 edges.remove(pointer);
        //                 pointer--;
        //                 changed = true;
        //             }
        //         }
        //     }

        //     // Edges required are n*(n-1)/2
        //     int edgesNeeded = currentlyVisited.size() * (currentlyVisited.size()-1) / 2;
        //     if(edgesNeeded == currentEdgeCount)  finalAns++;

        //     // System.out.println(edges);
        //     // System.out.println(visited);
        //     // System.out.println(currentEdgeCount + " " + edgesNeeded + " " + finalAns);
        // }

        // // System.out.println(finalAns);
        // // System.out.println(visited);
        // finalAns += (n - visited.size());

        // return finalAns;
    }
}
