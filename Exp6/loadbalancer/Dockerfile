FROM nginx:latest
COPY nginx.conf /etc/nginx/conf.d/default.conf
# WORKDIR /usr/share/nginx/html
# COPY build/ .
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]