package com.whatjustchanged.core.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/whatjustchanged/core/data/ConfigManager;", "", "getApiKey", "", "getApiUrl", "getPort", "", "data_debug"})
public abstract interface ConfigManager {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getApiUrl();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getApiKey();
    
    public abstract int getPort();
}