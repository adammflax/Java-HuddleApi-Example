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

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import net.smartam.leeloo.client.validator.CodeTokenValidator;
import net.smartam.leeloo.client.validator.CodeValidator;
import net.smartam.leeloo.client.validator.OAuthClientValidator;
import net.smartam.leeloo.client.validator.TokenValidator;
import net.smartam.leeloo.common.OAuth;
import net.smartam.leeloo.common.exception.OAuthProblemException;
import net.smartam.leeloo.common.utils.OAuthUtils;


/**
 * @author Maciej Machulak
 * @author Lukasz Moren
 */
public class OAuthAuthzResponse extends OAuthClientResponse {

    protected OAuthAuthzResponse(HttpServletRequest request, OAuthClientValidator validator) {
        Map<String, String[]> params = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : params.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();
            if (!OAuthUtils.hasEmptyValues(values)) {
                parameters.put(key, values[0]);
            }
        }
        this.validator = validator;
    }

    public static OAuthAuthzResponse oauthCodeAuthzResponse(HttpServletRequest request)
        throws OAuthProblemException {
        OAuthAuthzResponse response = new OAuthAuthzResponse(request, new CodeValidator());
        response.validate();
        return response;
    }

    public static OAuthAuthzResponse oAuthCodeAndTokenAuthzResponse(HttpServletRequest request)
        throws OAuthProblemException {
        OAuthAuthzResponse response = new OAuthAuthzResponse(request, new CodeTokenValidator());
        response.validate();
        return response;
    }

    public static OAuthAuthzResponse oauthTokenAuthzResponse(HttpServletRequest request)
        throws OAuthProblemException {
        OAuthAuthzResponse response = new OAuthAuthzResponse(request, new TokenValidator());
        response.validate();
        return response;
    }

    public String getAccessToken() {
        return getParam(OAuth.OAUTH_ACCESS_TOKEN);
    }

    public String getExpiresIn() {
        return getParam(OAuth.OAUTH_EXPIRES_IN);
    }

    public String getScope() {
        return getParam(OAuth.OAUTH_SCOPE);
    }

    public String getCode() {
        return getParam(OAuth.OAUTH_CODE);
    }

    public String getState() {
        return getParam(OAuth.OAUTH_STATE);
    }

    public String getParam(String key) {
        return this.parameters.get(key);
    }

    protected void setBody(String body) {
        this.body = body;
    }

    protected void setContentType(String contentType) {
        this.contentType = contentType;
    }

    protected void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

}
