package com.example.androiddevchallenge.data.model

import com.example.androiddevchallenge.R

data class Puppy(
    val id: Int = -1,
    val photo: Int = -1,
    val name: String = "",
    val type: String = "",
    val sex: String = "",
    val weight: Int = -1,
    val color: String = "",
    val age: Int = -1,
    val description: String = ""
)

fun getPuppyFromId(id: Int): Puppy {
    return getPuppyList().find { puppy -> id == puppy.id } ?: Puppy()
}

fun getPuppyList(): List<Puppy> {
    return listOf(
        Puppy(
            id = 1,
            photo = R.drawable.husky,
            name = "Buddy",
            type = "Husky",
            sex = "Male",
            weight = 4,
            age = 2,
            color = "White",
            description = "This is Buddy. A husky puppy with white and black fur, too cute to handle. Way more energetic than you. He craves attention most of the time because he is scared of being abandoned or ignored. He gives a feeling of protection. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
        ),
        Puppy(
            id = 2,
            photo = R.drawable.pomeranian,
            name = "Tipsy",
            type = "Pomeranian",
            sex = "Female",
            weight = 10,
            age = 4,
            color = "Golden",
            description = "This is Tipsy. A pomeranian puppy, too cute to handle. Way more energetic than you. She craves attention most of the time because she is scared of being abandoned or ignored. She gives a feeling of protection. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
        ),
        Puppy(
            id = 3,
            photo = R.drawable.shih_tzu,
            name = "Eva",
            type = "Shih Tzu",
            sex = "Female",
            weight = 15,
            age = 5,
            color = "White",
            description = "This is Eva. A shih tzu puppy, too cute to handle. Way more energetic than you. She craves attention most of the time because she is scared of being abandoned or ignored. She gives a feeling of protection. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
        ),
        Puppy(
            id = 4,
            photo = R.drawable.cavalier_king_charles_spaniel,
            name = "Odin",
            type = "Cavalier King",
            sex = "Male",
            weight = 9,
            age = 4,
            color = "White",
            description = "This is Odin. A cavalier king charles spaniel puppy, too cute to handle. Way more energetic than you. He craves attention most of the time because he is scared of being abandoned or ignored. He gives a feeling of protection. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
        ),
        Puppy(
            id = 5,
            photo = R.drawable.dachshund,
            name = "Levi",
            type = "Dachshund",
            sex = "Male",
            weight = 12,
            age = 3,
            color = "Black",
            description = "This is Levi. A dachshund puppy, too cute to handle. Way more energetic than you. He craves attention most of the time because he is scared of being abandoned or ignored. He gives a feeling of protection. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
        ),
        Puppy(
            id = 6,
            photo = R.drawable.akita,
            name = "Myra",
            type = "Akita",
            sex = "Female",
            weight = 20,
            age = 7,
            color = "Golden",
            description = "This is Myra. A akita puppy, too cute to handle. Way more energetic than you. She craves attention most of the time because she is scared of being abandoned or ignored. She gives a feeling of protection. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
        ),
        Puppy(
            id = 7,
            photo = R.drawable.labrador_retriever,
            name = "Dexter",
            type = "Labrador Retriever",
            sex = "Male",
            weight = 10,
            age = 4,
            color = "White",
            description = "This is Dexter. A labrador retriever puppy, too cute to handle. Way more energetic than you. He craves attention most of the time because he is scared of being abandoned or ignored. He gives a feeling of protection. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
        ), Puppy(
            id = 8,
            photo = R.drawable.australian_terrier,
            name = "Ruby",
            type = "Australian Terrier",
            sex = "Female",
            weight = 20,
            color = "Golden",
            age = 6,
            description = "This is Ruby. A australian terrier puppy, too cute to handle. Way more energetic than you. She craves attention most of the time because she is scared of being abandoned or ignored. She gives a feeling of protection. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
        ), Puppy(
            id = 9,
            photo = R.drawable.pug,
            name = "Sprite",
            type = "Pug",
            sex = "Male",
            weight = 10,
            age = 5,
            color = "White",
            description = "This is Sprite. A pug, too cute to handle. Way more energetic than you. He craves attention most of the time because he is scared of being abandoned or ignored. He gives a feeling of protection. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
        ), Puppy(
            id = 10,
            photo = R.drawable.dalmatian,
            name = "Inu",
            type = "Dalmatian",
            sex = "Female",
            weight = 7,
            age = 2,
            color = "White",
            description = "This is Inu. A dalmatian puppy, too cute to handle. Way more energetic than you. She craves attention most of the time because she is scared of being abandoned or ignored. She gives a feeling of protection. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
        )
    )
}
