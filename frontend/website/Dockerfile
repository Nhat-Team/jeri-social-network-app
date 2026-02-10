# -------- Stage 1: Build --------
    FROM node:20-alpine AS build

    WORKDIR /app
    
    # Copying depdencies files
    COPY package*.json ./
    
    # Installing libraries
    RUN npm ci --no-audit --no-fund
    
    # Copy source
    COPY . .
    
    # Build Vite app
    RUN npm run build
    
    # -------- Stage 2: Serve --------
    FROM nginx:alpine
    
    # Remove default config
    RUN rm /etc/nginx/conf.d/default.conf
    
    # Custom nginx config
    COPY nginx.conf /etc/nginx/conf.d/default.conf
    
    # Copy built files
    COPY --from=build /app/dist /usr/share/nginx/html
    
    EXPOSE 80
    
    CMD ["nginx", "-g", "daemon off;"]    