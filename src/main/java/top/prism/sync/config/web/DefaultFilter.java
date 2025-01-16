package top.prism.sync.config.web;

import org.noear.solon.annotation.Component;
import org.noear.solon.core.exception.StatusException;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Filter;
import org.noear.solon.core.handle.FilterChain;

@Component
public class DefaultFilter implements Filter {
    @Override
    public void doFilter(Context ctx, FilterChain chain) throws Throwable {
        try {
            chain.doFilter(ctx);
        } catch (StatusException e) {
            //如果 404 且路径以 / 结束（说明是目录）
            if (e.getCode() == 404 && ctx.pathNew().endsWith("/")) {
                ctx.forward(ctx.path() + "index.html");
            } else {
                throw e;
            }
        }
    }
}