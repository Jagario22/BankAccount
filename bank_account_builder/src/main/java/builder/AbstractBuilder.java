package builder;

import util.BundleUtil;

import java.util.Map;

public interface AbstractBuilder {

    default Map<String, String> getKeyValueMapByBundleProperties() {
        return BundleUtil.getBundleProperties();
    }

    void buildDataList();


}
