/**
 *       Copyright 2010 Newcastle University
 *           Maciej Machulak, Lukasz Moren
 *
 *          http://research.ncl.ac.uk/smart/
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package net.smartam.leeloo.client.response;

import java.util.HashMap;
import java.util.Map;

import net.smartam.leeloo.client.validator.OAuthClientValidator;
import net.smartam.leeloo.common.exception.OAuthProblemException;

/**
 * @author Maciej Machulak
 * @author Lukasz Moren
 */
public abstract class OAuthClientResponse {

    protected String body;
    protected String contentType;
    protected int responseCode;

    protected OAuthClientValidator validator;
    protected Map<String, String> parameters = new HashMap<String, String>();

    public abstract String getParam(String param);

    protected abstract void setBody(String body) throws OAuthProblemException;

    protected abstract void setContentType(String contentTypr);

    protected abstract void setResponseCode(int responseCode);

    protected void init(String body, String contentType, int responseCode) throws OAuthProblemException {
        this.setBody(body);
        this.setContentType(contentType);
        this.setResponseCode(responseCode);
        this.validate();

    }

    protected void validate() throws OAuthProblemException {
        validator.validate(this);
    }
}
