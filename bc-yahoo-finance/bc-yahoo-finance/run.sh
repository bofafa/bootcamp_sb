# # Stop and remove existing containers if any
# docker-compose down

# # Remove old images (if needed)
# docker rmi bc-yahoo-finance:0.0.1

# # Run Postgres by docker-compose
# # docker run --name my_postgres -e POSTGRES_PASSWORD=mysecretpassword -d -p 5432:5432 postgres

# # Build docker images for containers
# cd /Users/bohui/documents/bootcamp/bootcamp_sb/bc-yahoo-finance/bc-yahoo-finance
# mvn clean install

# docker build -t bc-yahoo-finance:0.0.1 -f Dockerfile .

# # Redeploy containers
# docker compose up -d