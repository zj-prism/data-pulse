package top.primsnet.sync.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.aspect.Interceptor;
import org.noear.solon.core.aspect.Invocation;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Filter;
import org.noear.solon.core.handle.FilterChain;
import top.primsnet.sync.common.result.Result;


@Component
public class ServiceExceptionHandler implements Filter {

    /**
     * @param ctx
     * @param chain
     * @throws Throwable
     */
    @Override
    public void doFilter(Context ctx, FilterChain chain) throws Throwable {
        try {
            chain.doFilter(ctx);
        } catch (ServiceException e){
            ctx.render(Result.error(e.getCode(), e.getMsg()));
        }catch (Throwable e) {
            ctx.render(Result.error(ErrorCode.INTERNAL_SERVER_ERROR));
        }
    }
}