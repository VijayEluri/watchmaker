// ============================================================================
//   Copyright 2006, 2007, 2008 Daniel W. Dyer
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.
// ============================================================================
package org.uncommons.watchmaker.examples.geneticprogramming;

import java.util.Random;
import org.uncommons.watchmaker.framework.Probability;

/**
 * Convenient base class for {@link Node}s that have no sub-trees.
 * @author Daniel Dyer
 */
abstract class LeafNode implements Node
{
    /**
     * Leaf nodes always have a depth of 1 since they have no child nodes.
     * @return 1 
     */
    public int getDepth()
    {
        return 1;
    }

    
    /**
     * {@inheritDoc}
     */
    public int countNodes()
    {
        return 1;
    }


    public Node getNode(int index)
    {
        if (index != 0)
        {
            throw new IndexOutOfBoundsException("Invalid node index: " + index);
        }
        return this;
    }


    public Node replaceNode(int index, Node newNode)
    {
        if (index != 0)
        {
            throw new IndexOutOfBoundsException("Invalid node index: " + index);
        }
        return newNode;        
    }

    
    /**
     * {@inheritDoc}
     */
    public Node mutate(Random rng, Probability mutationProbability, TreeFactory treeFactory)
    {
        if (mutationProbability.nextEvent(rng))
        {
            return treeFactory.generateRandomCandidate(rng);
        }
        else
        {
            // Node is unchanged.
            return this;
        }
    }


    @Override
    public String toString()
    {
        return print();
    }
}
