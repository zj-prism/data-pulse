package top.prism.sync.common.exception;

import cn.hutool.core.exceptions.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Component;
import org.noear.solon.core.exception.StatusException;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Filter;
import org.noear.solon.core.handle.FilterChain;
import top.prism.sync.common.result.Result;


@Slf4j
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
        }catch (StatusException e){
          throw e;
        } catch (ServiceException e){
            ctx.render(Result.error(e.getCode(), e.getMsg()));
        }catch (Throwable e) {
            log.error("捕获到未处理异常:\n{}", ExceptionUtil.stacktraceToString(e));
            ctx.render(Result.error(ErrorCode.INTERNAL_SERVER_ERROR));
        }
    }
}