package dev.neuralnexus.ampapi.types;

/**
 * ModuleInfo - A class to represent the ModuleInfo object returned by the GetModuleInfo() method.
 * @author p0t4t0sandwich
 */
public class ModuleInfo {
    /**
     * Name - The name of the module
     * Author - The author of the module
     * AppName - The app name
     * SupportsSleep - Whether the module supports sleep
     * LoadedPlugins - The loaded plugins
     * AMPVersion - The AMP version
     * AMPBuild - The AMP build
     * ToolsVersion - The tools version
     * APIVersion - The API version
     * VersionCodename - The version codename
     * Timestamp - The timestamp
     * BuildSpec - The build spec
     * {@link Branding Branding} - The branding object
     * Analytics - Whether analytics are enabled
     * FeatureSet - The feature set
     * InstanceId - The instance ID
     * InstanceName - The instance name
     * FriendlyName - The friendly name
     * EndpointURI - The endpoint URI
     * PrimaryEndpoint - The primary endpoint
     * ModuleName - The module name
     * IsRemoteInstance - Whether the instance is remote
     * DisplayBaseURI - The display base URI
     * RequiresFullLoad - Whether a full load is required
     * AllowRememberMe - Whether remember me is allowed
     */
    public String Name;
    public String Author;
    public String AppName;
    public boolean SupportsSleep;
    public String[] LoadedPlugins;
    public String AMPVersion;
    public String AMPBuild;
    public String ToolsVersion;
    public String APIVersion;
    public String VersionCodename;
    public String Timestamp;
    public String BuildSpec;
    public Branding Branding;
    public boolean Analytics;
    public String[] FeatureSet;
    public String InstanceId;
    public String InstanceName;
    public String FriendlyName;
    public String EndpointURI;
    public String PrimaryEndpoint;
    public String ModuleName;
    public boolean IsRemoteInstance;
    public String DisplayBaseURI;
    public boolean RequiresFullLoad;
    public boolean AllowRememberMe;

    /**
     * toString
     * @return A string representation of the object
     */
    public String toString() {
        return "ModuleInfo{Name=" + this.Name + ", Author=" + this.Author + ", AppName=" + this.AppName + ", SupportsSleep=" + this.SupportsSleep + ", LoadedPlugins=" + java.util.Arrays.deepToString(this.LoadedPlugins) + ", AMPVersion=" + this.AMPVersion + ", AMPBuild=" + this.AMPBuild + ", ToolsVersion=" + this.ToolsVersion + ", APIVersion=" + this.APIVersion + ", VersionCodename=" + this.VersionCodename + ", Timestamp=" + this.Timestamp + ", BuildSpec=" + this.BuildSpec + ", Branding=" + this.Branding + ", Analytics=" + this.Analytics + ", FeatureSet=" + java.util.Arrays.deepToString(this.FeatureSet) + ", InstanceId=" + this.InstanceId + ", InstanceName=" + this.InstanceName + ", FriendlyName=" + this.FriendlyName + ", EndpointURI=" + this.EndpointURI + ", PrimaryEndpoint=" + this.PrimaryEndpoint + ", ModuleName=" + this.ModuleName + ", IsRemoteInstance=" + this.IsRemoteInstance + ", DisplayBaseURI=" + this.DisplayBaseURI + ", RequiresFullLoad=" + this.RequiresFullLoad + ", AllowRememberMe=" + this.AllowRememberMe + "}";
    }

    /**
     * Branding - A class to represent the Branding object returned by the GetModuleInfo() method.
     * @author p0t4t0sandwich
     * @see ModuleInfo
     */
    public static class Branding {
        /**
         * DisplayBranding - Whether to display branding
         * PageTitle - The page title
         * CompanyName - The company name
         * WelcomeMessage - The welcome message
         * BrandingMessage - The branding message
         * ShortBrandingMessage - The short branding message
         * URL - The URL
         * SupportURL - The support URL
         * SupportText - The support text
         * SubmitTicketURL - The submit ticket URL
         * LogoURL - The logo URL
         * BackgroundURL - The background URL
         * SplashFrameURL - The splash frame URL
         * ForgotPasswordURL - The forgot password URL
         */
        public boolean DisplayBranding;
        public String PageTitle;
        public String CompanyName;
        public String WelcomeMessage;
        public String BrandingMessage;
        public String ShortBrandingMessage;
        public String URL;
        public String SupportURL;
        public String SupportText;
        public String SubmitTicketURL;
        public String LogoURL;
        public String BackgroundURL;
        public String SplashFrameURL;
        public String ForgotPasswordURL;

        /**
         * toString
         * @return A string representation of the object
         */
        public String toString() {
            return "Branding{DisplayBranding=" + this.DisplayBranding + ", PageTitle=" + this.PageTitle + ", CompanyName=" + this.CompanyName + ", WelcomeMessage=" + this.WelcomeMessage + ", BrandingMessage=" + this.BrandingMessage + ", ShortBrandingMessage=" + this.ShortBrandingMessage + ", URL=" + this.URL + ", SupportURL=" + this.SupportURL + ", SupportText=" + this.SupportText + ", SubmitTicketURL=" + this.SubmitTicketURL + ", LogoURL=" + this.LogoURL + ", BackgroundURL=" + this.BackgroundURL + ", SplashFrameURL=" + this.SplashFrameURL + ", ForgotPasswordURL=" + this.ForgotPasswordURL + "}";
        }
    }
}
