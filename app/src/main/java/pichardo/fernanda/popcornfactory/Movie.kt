package pichardo.fernanda.popcornfactory

data class Movie ( var title: String,
                   var image: Int,
                   var header: Int,
                   var synopsis: String,
                   var seats: ArrayList<Client>){
}