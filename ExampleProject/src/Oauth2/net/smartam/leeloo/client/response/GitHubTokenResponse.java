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

import net.smartam.leeloo.common.OAuth;
import net.smartam.leeloo.common.utils.OAuthUtils;


/**
 * @author Maciej Machulak
 * @author Lukasz Moren
 */
public class GitHubTokenResponse extends OAuthAccessTokenResponse {


    public String getAccessToken() {
        return parameters.get(OAuth.OAUTH_ACCESS_TOKEN);
    }

    public String getExpiresIn() {
        return parameters.get(OAuth.OAUTH_EXPIRES_IN);
    }

    public String getRefreshToken() {
        return parameters.get(OAuth.OAUTH_EXPIRES_IN);
    }

    public String getScope() {
        return parameters.get(OAuth.OAUTH_SCOPE);
    }

    protected void setBody(String body) {
        this.body = body;
        parameters = OAuthUtils.decodeForm(body);
    }

    protected void setContentType(String contentType) {
        this.contentType = contentType;
    }

    protected void setResponseCode(int code) {
        this.responseCode = code;
    }

    public String getParam(String name) {
        return parameters.get(name);
    }

}
