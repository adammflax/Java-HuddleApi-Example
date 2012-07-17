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

import net.smartam.leeloo.client.validator.TokenValidator;
import net.smartam.leeloo.common.exception.OAuthProblemException;

/**
 * @author Maciej Machulak
 * @author Lukasz Moren
 */
public abstract class OAuthAccessTokenResponse extends OAuthClientResponse {

    public abstract String getAccessToken();

    public abstract String getExpiresIn();

    public abstract String getRefreshToken();

    public abstract String getScope();

    public String getBody() {
        return body;
    }

    @Override
    protected void init(String body, String contentType, int responseCode) throws OAuthProblemException {
        validator = new TokenValidator();
        super.init(body, contentType, responseCode);
    }
}
