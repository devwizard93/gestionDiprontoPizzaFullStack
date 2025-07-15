import { HttpInterceptorFn } from '@angular/common/http';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const cloned = req.clone({
    headers: req.headers.set('Authorization', 'Basic YWRtaW46YWRtaW4=')
  });
  return next(cloned);
};
