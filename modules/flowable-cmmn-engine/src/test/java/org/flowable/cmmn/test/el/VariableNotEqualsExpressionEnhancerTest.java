/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flowable.cmmn.test.el;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.flowable.common.engine.impl.el.function.VariableNotEqualsExpressionFunction;
import org.junit.Test;

/**
 * @author Joram Barrez
 */
public class VariableNotEqualsExpressionEnhancerTest {
    
    private VariableNotEqualsExpressionFunction expressionFunction = new VariableNotEqualsExpressionFunction("planItemInstance");
    
    @Test
    public void testRegexNameReplacement() {
        assertRegexCorrect("${variables:notEquals(myVar,123)}", "${variables:notEquals(planItemInstance,'myVar',123)}");
        assertRegexCorrect("${vars:notEquals(myVar,123)}", "${variables:notEquals(planItemInstance,'myVar',123)}");
        assertRegexCorrect("${var:notEquals(myVar,123)}", "${variables:notEquals(planItemInstance,'myVar',123)}");
        
        assertRegexCorrect("${variables:ne(myVar,123)}", "${variables:notEquals(planItemInstance,'myVar',123)}");
        assertRegexCorrect("${vars:ne(myVar,123)}", "${variables:notEquals(planItemInstance,'myVar',123)}");
        assertRegexCorrect("${var:ne(myVar,123)}", "${variables:notEquals(planItemInstance,'myVar',123)}");
    }
        
    public void assertRegexCorrect(String in, String out) {
        assertEquals(out, expressionFunction.enhance(in));
    }

}
