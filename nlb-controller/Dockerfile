# a nginx dockerfile to deploy react application
FROM nginx:1.21.3-alpine
COPY build /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]