<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Product Details</title>
            <!-- Google Web Fonts -->
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link
                href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap"
                rel="stylesheet">

            <!-- Icon Font Stylesheet -->
            <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
            <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

            <!-- Libraries Stylesheet -->
            <link href="/client/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
            <link href="/client/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">


            <!-- Customized Bootstrap Stylesheet -->
            <link href="/client/css/bootstrap.min.css" rel="stylesheet">

            <!-- Template Stylesheet -->
            <link href="/client/css/style.css" rel="stylesheet">


        </head>

        <body>
            <!-- Hero Start -->
            <div class="container-fluid py-5 mb-5 hero-header">
                <div class="container py-5">
                    <div class="row g-5 align-items-center">
                        <div class="col-md-12 col-lg-7">
                            <h1 class="mb-5 display-3 text-primary">あなたの『欲しい』が必ず見つかる</h1>
                            <h4 class="mb-3 text-secondary">幅広い品揃えと、ユーザーのニーズに応えることに自信があることを表現します。
                            </h4>
                            <div class="position-relative mx-auto">
                                <input class="form-control border-2 border-secondary w-75 py-3 px-4 rounded-pill"
                                    type="number" placeholder="Search">
                                <button type="submit"
                                    class="btn btn-primary border-2 border-secondary py-3 px-4 position-absolute rounded-pill text-white h-100"
                                    style="top: 0; right: 25%;">Submit Now</button>
                            </div>
                        </div>
                        <div class="col-md-12 col-lg-5">
                            <div id="carouselId" class="carousel slide position-relative" data-bs-ride="carousel">
                                <div class="carousel-inner" role="listbox">
                                    <div class="carousel-item active rounded">
                                        <img src="https://cdn.thewirecutter.com/wp-content/media/2024/11/cheapgaminglaptops-2048px-7981.jpg?auto=webp&quality=75&width=1024"
                                            class="img-fluid w-100 h-100 bg-secondary rounded" alt="First slide">
                                        <a href="#" class="btn px-4 py-2 text-white rounded">PC</a>
                                    </div>
                                    <div class="carousel-item rounded">
                                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRv2M9UynBeJz8C8SnI3ViVFxqBkXTX03OL8g&s"
                                            class="img-fluid w-100 h-100 rounded" alt="Second slide">
                                        <a href="#" class="btn px-4 py-2 text-white rounded">MACBOOK</a>
                                    </div>
                                </div>
                                <button class="carousel-control-prev" type="button" data-bs-target="#carouselId"
                                    data-bs-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Previous</span>
                                </button>
                                <button class="carousel-control-next" type="button" data-bs-target="#carouselId"
                                    data-bs-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Next</span>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Hero End -->
        </body>

        </html>